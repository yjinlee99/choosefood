import { stepClasses } from '@mui/material';
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import Banner from './Banner';
import './Writing.css';

function Writing() {
    const [ Naming, setNaming ] = useState("");
    const [ Introducing, setIntroducing ] = useState("");
    const [ Need, setNeed ] = useState("");
    const [ Step, setStep ] = useState([]);
    const [ StepImg, setStepImg ] = useState([]);


    const onNamingHandler = (event) => {
        setNaming(event.currentTarget.value)
    }
    
    const onIntroducingHandler = (event) => {
        setIntroducing(event.currentTarget.value)
    }

    const onNeedHandler = (event) => {
        setNeed(event.currentTarget.value)
    }

    const onStepHandler = (event) => {
        setStep(event.currentTarget.value)
    }

    const onStepImgHandler = (event) => {
        setStepImg(event.currentTarget.value)
    }

    const goBackend = () => {
        if(window.confirm("게시물을 등록 하시겠습니까?")) {
            fetch('/post', {
            method: 'post',
            body: JSON.stringify({
                name: Naming,
                intro: Introducing,
                ingredient: Need,
                recipe: Step[0],
                stepimg: StepImg
                })
            }) 
        }
        window.location.replace("/Board")
    }

    const [ countList, setCountList ] = useState([0]);
    let num = 1
    
    const onAddDetailDiv = () => {
        let countArr = [ ...countList ]
        let counter = countArr.slice(-1)[0]
        counter += 1
        countArr.push(counter)
        setCountList(countArr)

        num += 1
    }

    const DetailList = (props) => {

        return (
            <div>
                {props.countList && props.countList.map((i, num) => (
                    <div key={i} >
                        <div className="Condition" id="Steps">
                            <div className="Step" id="stepWord"> STEP {num+1} </div>
                            <textarea id="Step-textarea" className="Step1" onChange={onStepHandler}/> 
                            <input type="file" id="Step-photo" className="Step1" onChange={onStepImgHandler} />
                        </div>
                    </div>
                ))}
            </div>
        )
    }

    return (
        <div>         
            <div className="Header"><Banner/></div>

            <div id="Conditions">
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

                <div className="Con" id="StepsCon"> 레시피 </div>

                <div>
                <DetailList countList={countList} num={num}/>
                <div id="Step-add" className="Step" onClick={onAddDetailDiv}> + </div>
                <div className="Step" id="stepNum"> </div> 
            
                <Link to="/SingleRecipe">
                    <div id="Submit" onClick={goBackend}> 등록하기 </div>
                </Link>
                <br />
                </div>
            </div>
        </div>
    );
}

export default Writing;
