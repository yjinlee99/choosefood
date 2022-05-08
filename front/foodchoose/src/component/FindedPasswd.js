import React from 'react';
import Banner from '../Banner';
import { Link } from 'react-router-dom';
import './FindedPasswd.css';

function FindedPasswd() {
    return (
      <div id='FindedPasswd'>
        <div className="Header"><Banner/></div>
        <div id='wrapFindedPasswd1'><br /><br />
              <div id='wrapFindedPasswd2'>
                    <p>@@@님의 비밀번호는</p>
                    <p>@@@@@</p>
                    <p>입니다</p>
                    <Link to='/LoginForm'>
                      <button id='buttonFindedPasswd'>로그인 하기</button>
                    </Link>
              </div>
              
        </div>
      </div>
  
    );
  }


export default FindedPasswd;