import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import './Logo.css';

function App() {
  return(
    <div>
        <Link to="/Main">
        <div class="AppLogo">
            <div className="App-logo"> FOOD FINDER </div>
            <div className="line"></div>
        </div>
        </Link>
    </div>
  );
}
export default App;
