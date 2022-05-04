import React from 'react';
import { Link } from 'react-router-dom';
import Banner from '../Banner';
import './FindedId.css';

function FindedId() {
    return (
      <div id='FindedId'>
        <div className="Header"><Banner/></div>

        <div id='wrapFindedId'>
            <div id='wrapFindedId2'>
                <p>@@@님의 아이디는</p>
                <p>@@@@@</p>
                <p>입니다</p>
                <Link to='/LoginForm'>
                  <button id='buttonFindedId'>로그인 하기</button>
                </Link>
                <Link to='/FindPasswd'>
                  <button id='buttonFindedId2'>비밀번호 찾기</button>
                </Link>
            </div>
              
        </div>
      </div>
    );
  }


export default FindedId;