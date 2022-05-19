import Container from '@mui/material/Container';
import Typography from '@mui/material/Typography';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import React from 'react';
import Banner from '../Banner';
import {useState, useEffect} from 'react';

function SignUp() {

  const [name, setName] = useState("")
  const [email, setEmail] = useState("")
  const [phone, setPhone] = useState("")
  const [passwd, setPasswd] = useState("")

  const onNameHandler = (event) => {
    setName(event.currentTarget.value)
  }
  const onEmailHandler = (event) => {
      setEmail(event.currentTarget.value)
  }

  const onPhoneHandler = (event) => {
    setPhone(event.currentTarget.value)
  }

  const onPasswdHandler = (event) => {
    setPasswd(event.currentTarget.value)
  }

  const goBackend = () => {
    alert(name+"님의 회원가입이 완료되었습니다!")
    fetch('/test', {
      method: 'post',
      body: JSON.stringify({
          name: name,
          email:email,
          phone:phone,
          passwd:passwd,
      })
  })
  .then(res => res.json())
  .then(res => {
      if (res.success) {
          alert("저장 완료");
      }
  })
  }
  
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
                  onChange={onNameHandler}
                />

                <TextField
                  required
                  fullWidth
                  id="email"
                  label="이메일"
                  name="email"
                  autoComplete="email"
                  onChange={onEmailHandler}
                />

                <TextField
                  required
                  fullWidth
                  id="phone"
                  label="전화번호"
                  name="phone"
                  autoComplete="phone"
                  onChange={onPhoneHandler}
                />

                <TextField
                  required
                  fullWidth
                  name="passwd"
                  label="비밀번호"
                  type="password"
                  id="passwd"
                  autoComplete="new-password"
                  onChange={onPasswdHandler}
                />

            <Button id="registerBtn" onClick={goBackend} type="submit" fullWidth variant="contained" style={{
                backgroundColor: "#ff6161", marginTop:"30px"              
            }}>회원가입</Button>


        </Container>
        </div>
    );
}

export default SignUp;