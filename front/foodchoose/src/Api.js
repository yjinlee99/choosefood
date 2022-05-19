import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Api() {
    const [ id, setId ] = useState(0);

    function stateApi() {
        setId(id+1)
    }
    useEffect(
        () => {
            alert("ok")
        }, []
    );

    function testAxios () {
        axios(
            {
                url: './user/checkEmail.do',
                method: 'post',
                data: {
                    email: 'test@naver.com', aaa: 'aaa222'
                },

                baseURl: 'http://localhost:3000',
            }
        ).then(function (response) {
            console.log(response.data)
            console.log(response.data.JavaData[0].NICKNAME)
        });
    }

    return (
       <div>
           test{id}
           <button onClick={()=> stateApi()}>test</button>
           <button onClick={()=> testAxios()}>axiosTest</button>
       </div> 
    );
}

export default Api;