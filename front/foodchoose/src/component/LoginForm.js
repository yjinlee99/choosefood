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
import SignUp from './SignUp';
import './LoginForm.css';

function LoginForm() {
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
                    label="Email Adress" name="email"
                    autoComplete="email"
                    autoFocus fullWidth />
                <TextField
                    label="Password" name="password" type="password"
                    autoComplete="current-password"
                    fullWidth />
                <FormControlLabel
                    control={<Checkbox value="remember" color="primary" />}
                    label="아이디 기억하기" />
                <Button id='submit' type="submit" fullWidth variant="contained">로그인</Button>
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
