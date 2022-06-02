import React, { Component }  from 'react';
import TextField from '@mui/material/TextField';
import Checkbox from '@mui/material/Checkbox';
import Button from '@mui/material/Button';
import FormControlLabel from '@mui/material/FormControlLabel';
import { Link } from 'react-router-dom';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Banner from '../Banner';
import './LoginForm.css';
import { useState, useEffect } from 'react';

function LoginForm() {
    const [email, setEmail] = useState("")
    const [passwd, setPasswd] = useState("")

    const onEmailHandler = (event) => {
        setEmail(event.currentTarget.value)
    }
    const onPasswdHandler = (event) => {
        setPasswd(event.currentTarget.value)
    }

      const goBackend = () => {
        if(email == "") {
            alert("이메일을 입력하세요.")
            return;
        }
        if(passwd == "") {
            alert("비밀번호를 입력하세요.")
            return;
        }
        fetch('/login', {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                email:email,
                password:passwd,
            })
        })
        .then(res => res.json())
        .then(memberResponse => {
            console.log(memberResponse);
            if(memberResponse.id) {
                alert(memberResponse.nickname + "님, 환영합니다.");
                sessionStorage.setItem("id", memberResponse.id);
                sessionStorage.setItem("email", email);
                sessionStorage.setItem("password", passwd);
                sessionStorage.setItem("nickname", memberResponse.nickname);
                sessionStorage.setItem("phone", memberResponse.phone);
                sessionStorage.setItem("img", memberResponse.img);
                window.location.replace("/Main")
            } else {
                alert("이메일이 존재하지 않거나 올바르지 않은 입력입니다.");
                window.location.replace("/LoginForm")
            }
        });
    }

    return(

        <><div>
            <div className="Header"><Banner/></div>
        </div>
        <Container component="main" maxWidth="xs" sx={{
            mt: '150px',
            display: 'flex',
            flexDirection: 'column',
            textAlign: 'center',
            alignItems: 'center'
        }}>
                <Typography component="h1" variant="h5" sx={{
                    mt: 2, mb: 3
                }}>
                    로그인
                </Typography>
                <TextField
                    label="이메일" name="email"
                    autoComplete="email"
                    autoFocus fullWidth 
                    onChange={onEmailHandler}
                    sx={{mb:1}}/>
                <TextField
                    label="비밀번호" name="password" type="password"
                    autoComplete="current-password"
                    fullWidth
                    onChange={onPasswdHandler}
                    sx={{mb:1}} />
                
                <Button id='submit' type="submit" onClick={goBackend} fullWidth variant="contained" sx={{mb:1}}>로그인</Button>
                <Button id='signup' fullWidth variant="contained" ><Link id="signup2" to='/SignUp'>회원가입</Link></Button>

            </Container>
            
            </>
            

    );

}

export default LoginForm;