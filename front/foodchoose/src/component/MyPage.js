import React from 'react';
import Banner from '../Banner';
import './MyPage.css';
import EditIcon from '@mui/icons-material/Edit';

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
                <EditIcon color='action' fontSize='small' onClick={()=>{alert('프로필사진, 닉네임변경')}} />
                </div><br />
                <div id='profileId'>_livingcoral00</div>
              </div>
            
              <div id='wrapEdit'>
                <button id='editProfile'>회원정보수정</button>
              </div>

            </div>

           </div>

            <div id='buttonContainer'>
             <button id='buttonMypage'>관심 메뉴</button>
             <button id='buttonMypage'>관심 식당</button>
             <button id='buttonMypage'>내가 쓴 글</button>
             <button id='buttonMypage'>내가 쓴 댓글</button>
            </div>
                
          </div>
        </div>
    )
}

export default MyPage;