import React from 'react';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { Link } from 'react-router-dom';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Banner from '../Banner';


function FindId() {
    return(

        <><div className="Header"><Banner /></div>
        
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
                아이디 찾기
            </Typography>
            <p>회원정보에 등록한 휴대폰번호를 입력해주세요.</p>
            <TextField
                label="휴대폰번호 입력" name="phone"
                autoComplete="phone"
                autoFocus fullWidth /><br />
            <Button id='submit' type="submit" fullWidth variant="contained">인증번호 받기</Button><br /><br />
            <TextField
                label="인증번호 입력" name="email"
                autoComplete="phone"
                autoFocus fullWidth /><br />
            <Link to='/FindedId'>
                <Button id='submit' type="submit" fullWidth variant="contained">다음</Button>
            </Link>

        </Container></>

    );

}

export default FindId;
