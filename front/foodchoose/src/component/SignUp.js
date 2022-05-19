import Container from '@mui/material/Container';
import Typography from '@mui/material/Typography';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import React, { useEffect } from 'react';
import Banner from '../Banner';

function SignUp() {
    useEffect(() => {
      fetch('/test', {
          method: 'post',
          body: JSON.stringify({
              name: "yeri",
              batch: 1
          })
      })
      .then(res => res.json())
      .then(res => {
          if (res.success) {
              alert("저장 완료");
          }
      })
    },[])

    return(
        <div>
        <div className="Header"><Banner /></div>

        <Container component="main" maxWidth="xs" sx={{
            mt: '150px',
            display: 'flex',
            flexDirection: 'column',
            textAlign: 'center',
            alignItems: 'center'
        }}>
            <Typography component="h1" variant="h5"sx={{
                mt: 2, mb:3
            }}>회원가입
            </Typography>

                <TextField
                  autoComplete="given-name"
                  name="name"
                  required
                  fullWidth
                  id="name"
                  label="이름(닉네임)"
                  autoFocus
                />

                <TextField
                  required
                  fullWidth
                  id="email"
                  label="이메일"
                  name="email"
                  autoComplete="email"
                />

                <TextField
                  required
                  fullWidth
                  id="phone"
                  label="전화번호"
                  name="phone"
                  autoComplete="phone"
                />

                <TextField
                  required
                  fullWidth
                  name="password"
                  label="비밀번호"
                  type="password"
                  id="password"
                  autoComplete="new-password"
                />

            <Button type="submit" onClick={()=>{alert("회원가입 완료!")}} fullWidth variant="contained" style={{
                backgroundColor: "#ff6161", marginTop:"30px"              
            }}>회원가입</Button>


        </Container>
        </div>
    );
}

export default SignUp;