import React from "react";
import './EditProfile.css';
import Banner from "../Banner";

function EditProfile(){
    return(
        <div id='EditProfile'>
            <div className="Header"><Banner /></div>
            <h1 id='main'>프로필 수정</h1>

            <div id='EditProfile2'>
                <h4 id='editProfileH4'>프로필 사진</h4>
                <div id='EditProfile5'>
                    <img id='editProfileImg' src="https://phinf.pstatic.net/contact/45/2012/12/4/gjdlstjs97_1354614541069.jpg?type=s160" width='100px' height='100px'/>
                    <input id='editProfileInput' type='file'/>
                </div>
            </div>

            <div id='EditProfile3'>
                <h4 id='editProfileH4'>닉네임</h4>
                <div id='EditProfile6'><input id='editProfileInput' placeholder="리빙코랄"></input></div>
            </div>

            <div id='EditProfile4'>
            <button id='editProfileButton'>수정</button>
            </div>

        </div>
    )
}

export default EditProfile;