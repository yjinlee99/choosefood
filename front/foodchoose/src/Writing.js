import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import Banner from './Banner';
import './Writing.css';

function Writing() {
    const [ Naming, setNaming ] = useState("");
    const [ Introducing, setIntroducing ] = useState("");
    const [ Need, setNeed ] = useState("");
    const [ Step, setStep ] = useState([]);
    const [ StepImg, setStepImg ] = useState("");
    const [ Thumb, setThumb ] = useState("");

    const id = sessionStorage.getItem("id", id);
    const thumbImg = sessionStorage.getItem("thumbImg", thumbImg);

    const onNamingHandler = (event) => {
        setNaming(event.currentTarget.value)
    }
    
    const onIntroducingHandler = (event) => {
        setIntroducing(event.target.value)
    }

    const onNeedHandler = (event) => {
        setNeed(event.currentTarget.value)
    }

    const onStepHandler = (e) => {
        setStep(e.target.value);
        console.log(e.currentTarget.value)
    }

    const onStepImgHandler = (event) => {
        setStepImg(event.target.files[0].name)
        setFileImage(URL.createObjectURL(event.target.files[0]));
        console.log(event.target.files[0].name)
    }

    const onThumbHandler = (event) => {
        setThumb(event.target.files[0].name)
        setFileImage(URL.createObjectURL(event.target.files[0]));
        console.log(event.target.files[0].name)
    }

    const goBackend = () => {
        if(window.confirm("게시물을 등록 하시겠습니까?")) {
            fetch('/post/save', {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                memberId: id,
                title: Naming,
                introduce: Introducing,
                thumbImg: Thumb,
                ingredient: Need,
                stepImg: StepImg,
                recipe: Step
                })
            }) 
        }
        window.location.replace("/Board")
    }

  //파일 미리볼 url을 저장해줄 state
  const [fileImage, setFileImage] = useState("");

  // 파일 저장
  const saveFileImage = (e) => {
    setFileImage(URL.createObjectURL(e.target.files[0]));
    document.getElementById("postThumbImg").style.display="none";
  };
    return (
        <div>         
            <div className="Header"><Banner/></div>
            

            <div id="Conditions">
                <div className="Condition" id="Thumbnail">
                    <div className="Con"> 썸네일 </div>
                        {fileImage && (
                            <img alt="sample" src={fileImage}/>
                        )}
                    <input id="post-thumb" type="file" onChange={onThumbHandler} />
                </div>

                <div className="Condition" id="Naming">
                    <div className="Con"> 레시피 제목 </div>
                    <textarea className="Naming-textarea" id="Naming-text" onChange={onNamingHandler}/>
                </div>

                <div  className="Condition" id="Introducing">
                    <div className="Con"> 요리 소개 </div>
                    <textarea className="Introducing-textarea" id="Introducing-text" onChange={onIntroducingHandler}/>
                </div>

                <div className="Condition" id="Need">
                    <div className="Con"> 재료 </div>
                    <textarea className="Need-textarea" id="Need-text" onChange={onNeedHandler}/>
                </div>

                <div className="Condition" id="Step">
                    <div className="Con" id="StepsCon"> 레시피 </div>    
                    <textarea id="Step-textarea" onChange={onStepHandler} /> 
                </div>

                <Link to="/SingleRecipe" style={{textDecoration: "none"}}>
                    <div id="Submit" onClick={() => {
                         goBackend();
                         sessionStorage.setItem("thumbImg", Thumb);
                    }}> 등록하기 </div>
                </Link>
                <br />
            </div>
        </div>
    );
}

export default Writing;
