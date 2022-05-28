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
            body: JSON.stringify({
                email:email,
                passwd:passwd,
            })
        })
        .then(res => res.json())
        .then(response => {
            if(JSON.parse(response)) {
                alert("환영합니다.");
                sessionStorage.setItem("email", email);
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
                    onChange={onEmailHandler}/>
                <TextField
                    label="비밀번호" name="password" type="password"
                    autoComplete="current-password"
                    fullWidth
                    onChange={onPasswdHandler} />
                <FormControlLabel
                    control={<Checkbox value="remember" color="primary" />}
                    label="아이디 기억하기" />
                <Button id='submit' type="submit" onClick={goBackend} fullWidth variant="contained">로그인</Button>
                <Grid container>
                    <Grid item xs='4'>
                        <Link to='/FindId'>아이디 찾기</Link>
                    </Grid>
                    <Grid item xs='4'>
                        <Link to='/FindPasswd'>비밀번호 찾기</Link>
                    </Grid>
                    <Grid item xs='4'>
                        <Link to='/SignUp'>회원가입</Link>
                    </Grid>
                </Grid>

            </Container>
            
            </>
            

    );

}

export default LoginForm;
