import { ConnectingAirportsOutlined } from '@mui/icons-material';
import React, { useState, useEffect } from 'react';
import { Link } from "react-router-dom";
import './Banner.css';
import LoginForm from './component/LoginForm';

function Banner() {

    const logOut = () => {
        if(window.confirm("로그아웃 하시겠습니까?")) {
                alert("로그아웃 성공");
                window.sessionStorage.clear();
                window.location.reload();
        }
    }
  
    const onLog = () => {
        return (
            <div className="Wrap">
                <Link to="/Main">
                <div className="Logo"> FOOD FINDER </div>
                <Link to="/Main"><div className="Logout" onClick={logOut}> Logout </div></Link>
                <Link to='/MyPage'><div className="MyPage"> MyPage </div></Link>
                </Link>
            </div>
        );
    }

    const outLog = () => {
        return (
            <div className="Wrap">
                <Link to="/Main">
                <div className="Logo"> FOOD FINDER </div>
                <Link to="/LoginForm"><div className="Login"> Login </div></Link>
                </Link>
            </div>
        );
    }

    const [logState, setLogState] = useState();
  
    useEffect(() => {
      setLogState(window.sessionStorage.getItem("email"));
      console.log("logstate", logState);
    });
    return <div>{logState === null ? outLog() : onLog()}</div>
}

export default Banner;
