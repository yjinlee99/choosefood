import React, { useState, useEffect } from 'react';
import { Link } from "react-router-dom";
import './Banner.css';

function Banner() {
    return (
        <div className="Wrap">
            <Link to="/Main">
            <div className="Logo"> Living Coral </div>
            <Link to="/LoginForm"><div className="Login"> Login </div></Link>
            <Link to='/MyPage'><div className="MyPage"> MyPage </div></Link>
            </Link>
        </div>
    );
}

export default Banner;
