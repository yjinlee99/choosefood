import React, { useState, useEffect }  from 'react';
import './EditInfo.css';
import Banner from "../Banner";


function EditInfo(){
    const [user, setUser] = useState([[]]);
        useEffect(() => {
            fetch('/user')
                .then(response => response.json())
                .then(user => {
                    setUser(user);
                });
        },[])

    // const upDatePhone = () => {
    //     fetch('/phone', {
    //         method: 'post',
    //         body: JSON.stringify({
    //             email:email,
    //             passwd:passwd,
    //         })
    //     })
    // }
    return(
        <div id='EditInfo'>
            <div className="Header"><Banner/></div>
            <h1 id='main'>회원 정보 수정</h1>

            <div id='EditInfo2'>
                <div id='editInfoDiv'>
                    <h4 id='editInfoH4'>이메일</h4>
                    <div id='editInfoDiv2'>{user[0]}</div>
                </div>
                
                <div id='editInfoDiv'>
                    <h4 id='editInfoH4'>이름(닉네임)</h4>
                    <div id='editInfoDiv2'>{user[2]}</div>
                </div>

                <div id='editInfoDiv'>
                    <h4 id='editInfoH4'>전화번호</h4>
                    <div id='editInfoDiv2'>
                        <div>{user[3]}</div>
                    <button id='editInfoButton'>수정</button>
                    </div>
                </div>

                <div id='editInfoDiv'>
                    <h4 id='editInfoH4'>기존 비밀번호</h4>
                    <div id='editInfoDiv2'>
                        <input></input>
                    </div>
                </div>

                <div id='editInfoDiv'>
                    <h4 id='editInfoH4'>새로운 비밀번호</h4>
                    <div id='editInfoDiv2'>
                        <input></input>
                    </div>
                </div>

                <div id='editInfoDiv'>
                    <h4 id='editInfoH4'>새로운 비밀번호 재입력</h4>
                    <div id='editInfoDiv2'>
                        <input></input>
                    </div>
                </div>

            <button id='editInfoButton'>수정</button>

            </div>

            </div>

    )
}

export default EditInfo;