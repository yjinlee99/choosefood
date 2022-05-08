import React, { Component} from 'react';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import Refrigerator from './component/Refrigerator';
import LoginForm from './component/LoginForm';
import SignUp from './component/SignUp';
import FindId from './component/FindId';
import FindPasswd from './component/FindPasswd';
import FindedId from './component/FindedId';
import FindedPasswd from './component/FindedPasswd';
import MyPage from './component/MyPage';
import Logo from './Logo';
import Option from './Option';
import Main from './Main';
import Recipe from './Recipe';
import SingleRecipe from './SingleRecipe';
import SearchedRecipe from './SearchedRecipe';
import Board from './Board';
import Writing from './Writing';
import Restaurant from './component/Restaurant';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Logo />} />
      <Route path="/Option" element={<Option />} />
      <Route path="/Main" element={<Main />} />
      <Route path="/Recipe" element={<Recipe />} />
      <Route path="/SingleRecipe" element={<SingleRecipe />} />
      <Route path="/SearchedRecipe" element={<SearchedRecipe />} />
      <Route path="/Board" element={<Board />} />
      <Route path="/Writing" element={<Writing />} />
      
      <Route path="/Refrigerator" element={<Refrigerator />} />
      <Route path="/LoginForm" element={<LoginForm />} />
      <Route path="/SignUp" element={<SignUp />} />
      <Route path="/FindId" element={<FindId />} />
      <Route path="/FindPasswd" element={<FindPasswd />} />
      <Route path="/FindedId" element={<FindedId />} />
      <Route path="/FindedPasswd" element={<FindedPasswd />} />
      <Route path="/MyPage" element={<MyPage />} />
      <Route path="/Restaurant" element={<Restaurant />} />


      </Routes>
  );
}

export default App;
