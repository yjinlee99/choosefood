import React from "react";
import './EditInfo.css';
import Banner from "../Banner";


function EditInfo(){
    return(
        <div id='EditInfo'>
            <div className="Header"><Banner/></div>
            <h1 id='main'>회원정보수정</h1>

            <div id='EditInfo2'>
                <div id='editInfoDiv'>
                    <h4 id='editInfoH4'>아이디</h4>
                    <div id='editInfoDiv2'>_livingcoral00</div>
                </div>
                
                <div id='editInfoDiv'>
                    <h4 id='editInfoH4'>이름</h4>
                    <div id='editInfoDiv2'>김철수</div>
                </div>

                <div id='editInfoDiv'>
                    <h4 id='editInfoH4'>전화번호</h4>
                    <div id='editInfoDiv2'>
                        <div>010-1234-1234</div>
                    <button id='editInfoButton'>수정</button>
                    </div>
                </div>

                <div id='editInfoDiv'>
                    <h4 id='editInfoH4'>이메일</h4>
                    <div id='editInfoDiv2'>
                        <div>abcd123@hansung.ac.kr</div>
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