import React from 'react';
import { Link } from 'react-router-dom';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Banner from '../Banner';
import './FindPasswd.css';


function FindPasswd() {
    return(
        <div>
        <div className="Header"><Banner/></div>

        <Container component="main" maxWidth="xs" sx={{
            mt: '100px',
            display: 'flex',
            flexDirection: 'column',
            textAlign: 'center',
            alignItems: 'center'
        }}>
                <Typography component="h1" variant="h5" sx={{
                    mt: 2, mb: 3
                }}>
                    비밀번호 찾기
                </Typography>
                <p>아이디를 입력해주세요.</p>
                <TextField
                    label="아이디 입력" name="email"
                    autoComplete="email"
                    autoFocus fullWidth /><br />
                <Button id='submitFindPasswd' type="submit" fullWidth variant="contained" sx={{
                    backgroundColor: '#ff6161'
                }}>인증번호 발송</Button><br />
                <TextField
                    label="인증번호 입력" name="email"
                    autoComplete="email"
                    autoFocus fullWidth /><br />
                    <Link to='/FindedPasswd'>
                        <Button type="submit" fullWidth variant="contained" sx={{
                    backgroundColor: '#ff6161'
                }}>찾기</Button><br />
                    </Link>
            </Container>
            </div>

    );

}

export default FindPasswd;
