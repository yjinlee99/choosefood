<<<<<<< HEAD
import React, { useState } from 'react';
=======
import React from 'react';
>>>>>>> b30ff4544911c22b8445efdc92ad25b7580e087f
import Banner from '../Banner';
import { Link } from 'react-router-dom';
import './FindedPasswd.css';

function FindedPasswd() {
    return (
<<<<<<< HEAD
      <div>
=======
      <div id='FindedPasswd'>
>>>>>>> b30ff4544911c22b8445efdc92ad25b7580e087f
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