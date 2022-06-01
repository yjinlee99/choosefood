import React, { useRef, useState, useEffect } from 'react';
import './Refrigerator.css';
import Banner from '../Banner';
import { Link } from 'react-router-dom';
import UserList from "./UserList";
import CreateIngredient from "./CreateIngredient";


function Refrigerator() {
    const [userInfo, setUserInfo] = useState([[]]);
    useEffect(() => {
        fetch('/user')
            .then(response => response.json())
            .then(userInfo => {
                setUserInfo(userInfo);
            });
    },[])
  
    const [userRef, setUserRef] = useState([[]]);
    useEffect(() => {
        fetch('/userRef')
            .then(response => response.json())
            .then(userRef => {
                setUserRef(userRef);
            });
    },[])

    const [inputs, setInputs] = useState({ username: "" });
    const { username } = inputs;
    const onChange = (e) => {
      const { name, value } = e.target;
      setInputs({ ...inputs, [name]: value,});
    };
    const [users, setUsers] = useState([
      { id: 1, username: "딸기"},
      { id: 2, username: "초코"},
      { id: 3, username: "바나나"},
    ]);
    const nextId = useRef(4);
    const onCreate = () => {
      if(username == "") {
        alert("재료를 입력하세요.")
        return;
      } 
      const user = {
        id: nextId.current, username
      };
      setUsers(users.concat(user));
      setInputs({
        username: ""
      });
      nextId.current += 1;
    };
    
    const onRemove = (id) => {
      setUsers(users.filter((user) => user.id !== id));
    };

    const optionchecked4 = [];
    for (let i = 0; i < users.length; i++) {
      optionchecked4.push(users[i].username);
    }
    const goBackend = () => {
      fetch('/refoption', {
        method: 'post',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          users: optionchecked4,
        })
      })
    }

    const onUpdate = () => {
      fetch('/refUpdate', {
        method: 'post',
        body: JSON.stringify({
          users: users,
        })
      })
      alert("냉장고 재료가 수정 되었습니다.");
      window.location.replace("/Refrigerator")
    }
      
    return (
      <div>
        <div className="Header"><Banner/></div>

      <div id='Refrigerator'>
        <div id='wrap1'>
        <CreateIngredient
          username={username}
          onChange={onChange}
          onCreate={onCreate}/>
        </div>

        <div id='wrap'>
          <div>
             <UserList users={users} onRemove={onRemove} />
          </div>

          <div>
          <input id="edit" type='submit' value="수정하기" onClick={onUpdate}></input>
          </div>

        </div>

        <div>
        <Link to={{
          pathname: `/Recipe?theme=""&taste=""&ingredient=""&situation=""&refrigerator=${optionchecked4}`,
      }}>
          <input id='searchRecipe' type='submit' value="레시피 검색" onClick={goBackend}></input>
          </Link>
          
        </div>

        </div>


      </div>
  
    );
  }

export default Refrigerator;