import Container from '@mui/material/Container';
import Typography from '@mui/material/Typography';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import React from 'react';
import Banner from '../Banner';

function SignUp() {
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
            }}>
            회원가입
            </Typography>

                <TextField
                  autoComplete="given-name"
                  name="name"
                  required
                  fullWidth
                  id="name"
                  label="Name"
                  autoFocus
                />

                <TextField
                  required
                  fullWidth
                  id="email"
                  label="Email Address"
                  name="email"
                  autoComplete="email"
                />

                <TextField
                  required
                  fullWidth
                  name="password"
                  label="Password"
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