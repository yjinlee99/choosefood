import React, { useState, useEffect }  from 'react';
import Banner from '../Banner';
import './MyPage.css';
import EditIcon from '@mui/icons-material/Edit';
import { Link } from 'react-router-dom';

function MyPage(){
  const email = sessionStorage.getItem("email", email);
  const id = sessionStorage.getItem("id", id);
  const nickname = sessionStorage.getItem("nickname", nickname);
  const [user, setUser] = useState([[]]);
  useEffect(() => {
      fetch('/user')
          .then(response => response.json())
          .then(user => {
              setUser(user);
          });
  },[])
    return (
        <div>
          <div className="Header"><Banner /></div>

          <div id='mypageContainer'>
           <div id='profileContainer2'>
           <div id='profileContainer1'>
              
              <div id='imageContainer'>
                <img id='profileImage' src="/img/profile.png" width='100px' height='100px'/>
              </div>

              <div id='idContainer'>
                <div id='profileName'>{nickname}
                <Link to='/EditProfile'><EditIcon color='action' fontSize='small' /></Link>
                </div><br />
                <div id='profileId'>{email}</div>
              </div>
            
              <div id='wrapEdit'>
                <Link to='/EditInfo'><button id='editProfile'>회원 정보 수정</button></Link>
              </div>

            </div>

           </div>

            <div id='buttonContainer'>
             <Link to='/MyMenu'><button id='buttonMypage'>관심 메뉴</button></Link>
             <Link to='/MyRestaurant'><button id='buttonMypage'>관심 식당</button></Link>
             <Link to='/MyWriting'><button id='buttonMypage'>내가 쓴 글</button></Link>
             <Link to='/MyComment'><button id='buttonMypage'>내가 쓴 댓글</button></Link>
            </div>
                
          </div>
        </div>
    )
}

export default MyPage;