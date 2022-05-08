import React from 'react';
import Banner from '../Banner';
import './MyPage.css';
import EditIcon from '@mui/icons-material/Edit';
<<<<<<< HEAD
=======
import { Link } from 'react-router-dom';
>>>>>>> b30ff4544911c22b8445efdc92ad25b7580e087f

function MyPage(){
    return (
        <div>
          <div className="Header"><Banner /></div>

          <div id='mypageContainer'>
           <div id='profileContainer2'>
           <div id='profileContainer1'>
              
              <div id='imageContainer'>
                <img id='profileImage' src="https://phinf.pstatic.net/contact/45/2012/12/4/gjdlstjs97_1354614541069.jpg?type=s160" width='100px' height='100px'/>
              </div>

              <div id='idContainer'>
                <div id='profileName'>리빙코랄
<<<<<<< HEAD
                <EditIcon color='action' fontSize='small' onClick={()=>{alert('프로필사진, 닉네임변경')}} />
=======
                <Link to='/EditProfile'><EditIcon color='action' fontSize='small' /></Link>
>>>>>>> b30ff4544911c22b8445efdc92ad25b7580e087f
                </div><br />
                <div id='profileId'>_livingcoral00</div>
              </div>
            
              <div id='wrapEdit'>
<<<<<<< HEAD
                <button id='editProfile'>회원정보수정</button>
=======
                <Link to='/EditInfo'><button id='editProfile'>회원정보수정</button></Link>
>>>>>>> b30ff4544911c22b8445efdc92ad25b7580e087f
              </div>

            </div>

           </div>

            <div id='buttonContainer'>
<<<<<<< HEAD
             <button id='buttonMypage'>관심 메뉴</button>
             <button id='buttonMypage'>관심 식당</button>
             <button id='buttonMypage'>내가 쓴 글</button>
             <button id='buttonMypage'>내가 쓴 댓글</button>
=======
             <Link to='/MyMenu'><button id='buttonMypage'>관심 메뉴</button></Link>
             <Link to='/MyRestaurant'><button id='buttonMypage'>관심 식당</button></Link>
             <Link to='/MyWriting'><button id='buttonMypage'>내가 쓴 글</button></Link>
             <Link to='/MyComment'><button id='buttonMypage'>내가 쓴 댓글</button></Link>
>>>>>>> b30ff4544911c22b8445efdc92ad25b7580e087f
            </div>
                
          </div>
        </div>
    )
}

export default MyPage;