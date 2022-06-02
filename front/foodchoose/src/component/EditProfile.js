import React from "react";
import './EditProfile.css';
import Banner from "../Banner";
import { useState, useEffect } from "react";

function EditProfile(){
  const id = sessionStorage.getItem("id", id);
  const nickname = sessionStorage.getItem("nickname", nickname);
  const img = sessionStorage.getItem("img", img);

  const [user, setUser] = useState([[]]);
  useEffect(() => {
      fetch('/user')
          .then(response => response.json())
          .then(user => {
              setUser(user);
          });
  },[])


  //파일 미리볼 url을 저장해줄 state
  const [fileImage, setFileImage] = useState("");

  // 파일 저장
  const saveFileImage = (e) => {
    setFileImage(URL.createObjectURL(e.target.files[0]));
    document.getElementById("editProfileImg").style.display='none';
  };


  const [newImg, setImg] = useState("")
  const [newNickname, setName] = useState("")
  
  const onImgHandler = (event) => {
      setImg(event.target.files[0].name);
      setFileImage(URL.createObjectURL(event.target.files[0]));
      document.getElementById("editProfileImg").style.display='none';
      console.log(event.target.files[0].name)
      
  }
  const onNameHandler = (event) => {
      setName(event.currentTarget.value)
  }

  const goBackendImg = () => {
    fetch('/updateprofile', {
        method: 'post',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            id:id,
            img:newImg,
            nickname:nickname,
        })
    })
    };

  const goBackendNickname = () => {
    fetch('/updateprofile', {
        method: 'post',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            id:id,
            img:img,
            nickname:newNickname,
        })
    })
    };
  
    return(
        
        <div id='EditProfile'>
            <div className="Header"><Banner /></div>
            <h1 id='main'>프로필 수정</h1>

            <table id='editProfileTable' width='800px' height='400px'>
              <tr>
                <td><h4 id='editProfileH4'>프로필 사진</h4></td>
                <td>
                {fileImage && (
                      <img
                        alt="sample"
                        src={fileImage}
                        style={{ margin: "auto", width:"100px", height:"100px", borderRadius:"70%", objectFit:'cover' }}
                      />
                    )}
                        <img id='editProfileImg' src={"\\img\\profile\\"+ img} width='100px' height='100px'/>
                        <input id='editProfileInput' 
                        name="imgUpload"
                        accept="image/*"
                        onChange={onImgHandler}
                        type='file'/>
                </td>
                <td>
                <button id='editImgButton' onClick={()=>{
                    goBackendImg();
                    sessionStorage.setItem("img", newImg);
                    alert("수정되었습니다.");
                    window.location.replace("/MyPage")
                  }}>수정</button>
                </td>
              </tr>
              <tr>
                <td><h4 id='editProfileH4'>닉네임</h4></td>
                <td>
                <input id='editProfileInput' onChange={onNameHandler} placeholder={nickname}></input>

                </td>
                <td>
                <button id='editNicknameButton' onClick={()=>{
                    goBackendNickname();
                    sessionStorage.setItem("nickname", newNickname);
                    alert("수정되었습니다.");
                    window.location.replace("/MyPage")
                  }}>수정</button>
                </td>
              </tr>

            </table>

        </div>
    )
}

export default EditProfile;