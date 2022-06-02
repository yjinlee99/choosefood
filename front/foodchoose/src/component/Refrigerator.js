import React, { useRef, useState, useEffect } from 'react';
import './Refrigerator.css';
import Banner from '../Banner';
import { Link } from 'react-router-dom';
import UserList from "./UserList";
import CreateIngredient from "./CreateIngredient";


function Refrigerator() {
    const Id = sessionStorage.getItem("id", Id);
    const [users, setUsers] = useState([{}]);
    const [userRef, setUserRef] = useState([[]]);

    useEffect(() => {
      if(sessionStorage.getItem("id")==null) {
        alert("로그인이 필요합니다.");
        window.location.replace("/Main");
      }
      fetch('/ref/member', {
        method: 'post',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            id: Id
        })
    })
    .then(res => res.json())
    .then(userRef => {
        setUserRef(userRef);
        setUsers(userRef);
    })
    },[])

    console.log(userRef)
    const [inputs, setInputs] = useState({ refrigerator: "" });
    const { refrigerator } = inputs;
    const onChange = (e) => {
      const { name, value } = e.target;
      setInputs({ ...inputs, [name]: value,});
    };
    //const [users, setUsers] = useState([
    //  { id: 1, username: "딸기"},
    //  { id: 2, username: "초코"},
    //  { id: 3, username: "바나나"},
    //  ]);
    const nextId = useRef(4);
    const onCreate = () => {
      if(refrigerator == "") {
        alert("재료를 입력하세요.")
        return;
      } 
      const user = {
        id: nextId.current, refrigerator
      };
      setUsers(users.concat(user));
      setInputs({
        refrigerator: ""
      });
      nextId.current += 1;
    };
    
    const onRemove = (id) => {
      setUsers(users.filter((user) => user.id !== id));
    };

    const optionchecked4 = [];
    for (let i = 0; i < users.length; i++) {
      optionchecked4.push(users[i].refrigerator);
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
      fetch('/ref/update', {
        method: 'post',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          id: Id,
          havingIngredient: users,
        })
        
      })
      console.log(userRef)
      console.log(users)
      alert("냉장고 재료가 수정 되었습니다.");
      window.location.replace("/Refrigerator")
    }

    console.log(userRef)
      
    return (
      <div>
        <div className="Header"><Banner/></div>

      <div id='Refrigerator'>
        <div id='wrap1'>
        <CreateIngredient
          refrigerator={refrigerator}
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