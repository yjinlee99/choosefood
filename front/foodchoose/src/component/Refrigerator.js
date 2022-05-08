import React, { useRef, useState } from 'react';
import './Refrigerator.css';
import Banner from '../Banner';
import { Link } from 'react-router-dom';
import UserList from "./UserList";
<<<<<<< HEAD
import CreateUser from "./CreateIngredient";
=======
import CreateIngredient from "./CreateIngredient";
>>>>>>> b30ff4544911c22b8445efdc92ad25b7580e087f


function Refrigerator() {

<<<<<<< HEAD
    const [inputs, setInputs] = useState({
      username: ""
      });
      const { username, email } = inputs;
      const onChange = (e) => {
      const { name, value } = e.target;
      setInputs({
      ...inputs,
      [name]: value,
      });
      };
      const [users, setUsers] = useState([
      {
      id: 1,
      username: "딸기"
      },
      {
      id: 2,
      username: "초코"
      },
      {
      id: 3,
      username: "바나나"
      },
      ]);
      const nextId = useRef(4);
      const onCreate = () => {
      const user = {
      id: nextId.current,
      username,
      email,
      };
      setUsers(users.concat(user));
      setInputs({
      username: "",
      email: "",
      });
      nextId.current += 1;
      };
      const onRemove = (id) => {
      setUsers(users.filter((user) => user.id !== id));
      };
      
    return (

      
      <div>

=======
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
      
    return (
      <div>
>>>>>>> b30ff4544911c22b8445efdc92ad25b7580e087f
        <div className="Header"><Banner/></div>

      <div id='Refrigerator'>
        <div id='wrap1'>
<<<<<<< HEAD
        <CreateUser
          username={username}
          email={email}
          onChange={onChange}
          onCreate={onCreate}/>

          {/* <input id='addText' name='textValue' value={textValue} onChange={onChange} placeholder=" 재료를 추가하세요!"></input>
          <button id="addButton" onClick={onCreate}>추가</button> */}
        </div>

        <div id='wrap'>

          <div>
            {/* {enters.map(value => (
              <span id='addedIngredient'>
                {value}
                <button id='deleteButton' onClick={onRemove}>x</button>
              </span>    
             ))} */}
             <UserList users={users} onRemove={onRemove} />

=======
        <CreateIngredient
          username={username}
          onChange={onChange}
          onCreate={onCreate}/>
        </div>

        <div id='wrap'>
          <div>
             <UserList users={users} onRemove={onRemove} />
>>>>>>> b30ff4544911c22b8445efdc92ad25b7580e087f
          </div>

          <div>
          <input id="edit" type='submit' value="수정하기" onClick={()=>{
            alert("수정되었습니다!\n(DB저장 구현해야함)")
          }}></input>
          </div>

        </div>

        <div>
        <Link to="/Recipe">
          <input id='searchRecipe' type='submit' value="레시피 검색!" ></input>
          </Link>
          
        </div>

        </div>


      </div>
  
    );
  }

export default Refrigerator;