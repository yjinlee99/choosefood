import React, { useState, useEffect }  from 'react';
import './EditInfo.css';
import Banner from "../Banner";


function EditInfo(){
    const email = sessionStorage.getItem("email", email);
    const id = sessionStorage.getItem("id", id);
    const nickname = sessionStorage.getItem("nickname", nickname);
    const password = sessionStorage.getItem("password", password);
    const phone2 = sessionStorage.getItem("phone", phone2);

    const [user, setUser] = useState([[]]);
        useEffect(() => {
            fetch('/user')
                .then(response => response.json())
                .then(user => {
                    setUser(user);
                });
        },[])

        const [phone, setPhone] = useState("")
        const [passwd, setPasswd] = useState("")
        const [newPasswd, setnewPasswd] = useState("")
        const [newPasswd2, setnewPasswd2] = useState("")

        const onPhoneHandler = (event) => {
            setPhone(event.currentTarget.value)
            document.getElementById("phone").innerHTML=event.currentTarget.value;
        }
        const onPasswdHandler = (event) => {
            setPasswd(event.currentTarget.value)
                if (event.currentTarget.value === password){
                document.getElementById("pwMessage").style.color="black";
                document.getElementById("pwMessage").innerHTML="비밀번호가 일치합니다";
            } else {
                document.getElementById("pwMessage").style.color="red";
                document.getElementById("pwMessage").innerHTML="비밀번호가 다릅니다";
            }
        }

        const onNewPasswdHandler = (event) => {
            setnewPasswd(event.currentTarget.value)

        }
        console.log("newPasswd: " +newPasswd+".");

        const onNewPasswdHandler2 = (event) => {
            setnewPasswd2(event.currentTarget.value)
            if( event.currentTarget.value === newPasswd ) {
                document.getElementById("pwMessage2").style.color="black";
                document.getElementById("pwMessage2").innerHTML="비밀번호가 일치합니다";
                document.getElementById("editPasswdButton").style.pointerEvents="";
            }else {
                document.getElementById("pwMessage2").style.color="red";
                document.getElementById("pwMessage2").innerHTML="비밀번호를 다시 입력해주세요";
                document.getElementById("editPasswdButton").style.pointerEvents="none";
            }
        }

        //전화번호 수정
        const goBackendPhone = () => {
            fetch('/updateinfo', {
                method: 'post',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({
                    id:id,
                    phone: phone,
                    password:password, 
                })
            })
            };

        //비밀번호 수정
        const goBackendPasswd = () => {
            fetch('/updateinfo', {
                method: 'post',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({
                    id:id,
                    phone: phone2,
                    password: newPasswd2,
                })
            })
            };   
  
    return(
        <div id='EditInfo'>
            <div className="Header"><Banner/></div>
            <h1 id='main'>회원 정보 수정</h1>

            <table id='editInfoTable' width="700px">
                <tr>
                    <td><h4 id='editInfoH4'>이메일</h4></td>
                    <td><div id='editInfoDiv2'>{email}</div></td>
                </tr>
                <tr>
                    <td><h4 id='editInfoH4'>이름</h4></td>
                    <td><div id='editInfoDiv2'>{nickname}</div></td>
                </tr>
                <tr>
                    <td><h4 id='editInfoH4'>전화번호</h4></td>
                    <td>
                        <div id="phone">{phone2}</div>
                        <input id="newPhone" onChange={onPhoneHandler} style={{display:"none"}}></input>
                    </td>
                    <td>
                        <button id='editPhoneButton' onClick={()=>{
                                    document.getElementById("newPhone").style.display="";
                                    document.getElementById("editPhoneButton").style.display="none";
                                    document.getElementById("phone").style.display="none";
                                    document.getElementById("edited").style.display="";
                                }}>수정</button>
                        <button id="edited" onClick={()=>{
                            goBackendPhone();
                            document.getElementById("phone").style.display="";
                            document.getElementById("newPhone").style.display="none";
                            document.getElementById("edited").style.display="none";
                            document.getElementById("editPhoneButton").style.display="";
                            sessionStorage.setItem("phone", phone);
                            alert("전화번호가 변경되었습니다");
                            window.location.replace("/MyPage")
                            }} style={{display:'none'}}>완료</button>
                    </td>

                </tr>
                <tr>
                    <td><h4 id='editInfoH4'>기존 비밀번호</h4></td>
                    <td>
                        <input type="password" onChange={onPasswdHandler}></input>
                        <div id="pwMessage"></div>
                    </td>
                </tr>
                <tr>
                    <td><h4 id='editInfoH4'>새로운 비밀번호</h4></td>
                    <td><input type="password" onChange={onNewPasswdHandler}></input></td>
                </tr>
                <tr>
                    <td><h4 id='editInfoH4'>새로운 비밀번호 재입력</h4></td>
                    <td>
                        <input type="password" onChange={onNewPasswdHandler2} ></input>
                        <div id="pwMessage2"></div>
                    </td>
                    <td><button id='editPasswdButton' onClick={()=>{
                        goBackendPasswd();
                        sessionStorage.setItem("password", newPasswd2);
                        alert("비밀번호가 변경되었습니다");
                        window.location.replace("/MyPage")
                    }}>수정</button></td>
                </tr>
            </table>

        </div>
            

    )
}

export default EditInfo;