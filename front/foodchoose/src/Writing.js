import { stepClasses } from '@mui/material';
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import Banner from './Banner';
import './Writing.css';

function Writing() {
    const [ Naming, setNaming ] = useState("");
    const [ Introducing, setIntroducing ] = useState("");
    const [ Need, setNeed ] = useState("");
    const [ Step, setStep ] = useState("");


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

    var $optionchecked1 = document.querySelectorAll(".option-Box1:checked");
    var $optionchecked2 = document.querySelectorAll(".option-Box2:checked");
    var $optionchecked3 = document.querySelectorAll(".option-Box3:checked");
    var $optionchecked4 = document.querySelectorAll(".option-Box4:checked");


    const optionchecked1 = [];
    for (let i = 0; i < $optionchecked1.length; i++) {
        optionchecked1.push($optionchecked1[i].value)
    }
    const optionchecked2 = [];
    for (let i = 0; i < $optionchecked2.length; i++) {
        optionchecked2.push($optionchecked2[i].value)
    }
    const optionchecked3 = [];
    for (let i = 0; i < $optionchecked3.length; i++) {
        optionchecked3.push($optionchecked3[i].value)
    }
    const optionchecked4 = [];
    for (let i = 0; i < $optionchecked4.length; i++) {
        optionchecked4.push($optionchecked4[i].value)
    }

    const goBackend = () => {
        if(window.confirm("게시물을 등록 하시겠습니까?")) {
            fetch('/post', {
            method: 'post',
            body: JSON.stringify({
                name: Naming,
                intro: Introducing,
                ingredient: Need,
                recipe: Step
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
                        <div className="Condition" id="Steps" >
                            <div className="Step" id="stepWord"> STEP {num+1} </div>
                            <textarea id="Step-textarea" className="Step1"/> 
                            <input type="file" id="Step-photo" className="Step1" />
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

                <div className="Condition" id="Cataloging">
                    <div className="Con"> 카테고리 (옵션) </div>
                    <div id="Catal-options" >
                        <div className="Catal-option" id="Cataloging-text" > <b>테마별</b> &nbsp;
                            <input type="checkbox" id="한식" class="option-Box1" value="한식"/>
                            <label for="한식" >한식</label>
                            <input type="checkbox" id="중식"  class="option-Box1" value="중식" />
                            <label for="중식">중식</label>
                            <input type="checkbox" id="일식"  class="option-Box1" value="일식" />
                            <label for="일식">일식</label>
                            <input type="checkbox" id="양식"  class="option-Box1" value="양식" />
                            <label for="양식">양식</label>
                            <input type="checkbox" id="분식"  class="option-Box1" value="분식" />
                            <label for="분식">분식</label>
                            <input type="checkbox" id="디저트" class="option-Box1" value="디저트" />
                            <label for="디저트">디저트</label>
                        </div><br />

                        <div className="Catal-option"> <b>미각별</b> &nbsp;
                            <input type="checkbox" id="매콤" class="option-Box2" value="매콤" />
                            <label for="매콤">매콤</label>
                            <input type="checkbox" id="달콤" class="option-Box2" value="달콤" />
                            <label for="달콤">달콤</label>
                            <input type="checkbox" id="고소" class="option-Box2" value="고소" />
                            <label for="고소">고소</label>
                            <input type="checkbox" id="짭짤" class="option-Box2" value="짭짤" />
                            <label for="짭짤">짭짤</label>
                        </div><br />

                        <div className="Catal-option"> <b>재료별</b> &nbsp;
                            <input type="checkbox" id="고기"  class="option-Box3" value="고기"/>
                            <label for="고기">고기</label>
                            <input type="checkbox" id="채소" class="option-Box3" value="채소" />
                            <label for="채소">채소</label>
                            <input type="checkbox" id="떡" class="option-Box3" value="떡" />
                            <label for="떡">떡</label>
                            <input type="checkbox" id="밥" class="option-Box3" value="밥" />
                            <label for="밥">밥</label>
                            <input type="checkbox" id="해물" class="option-Box3" value="해물" />
                            <label for="해물">해물</label>
                            <input type="checkbox" id="과일" class="option-Box3" value="과일" />
                            <label for="과일">과일</label>
                            <input type="checkbox" id="빵/과자" class="option-Box3" value="빵/과자" />
                            <label for="빵/과자">빵/과자</label>
                            <input type="checkbox" id="두부/계란/우유" class="option-Box3" value="두부/계란/우유" />
                            <label for="두부/계란/우유">두부/계란/우유</label>
                            <input type="checkbox" id="면" class="option-Box3" value="면" />
                            <label for="면">면</label>
                        </div><br />

                        <div className="Catal-option"> <b>상황별</b> &nbsp;
                            <input type="checkbox" id="야식" class="option-Box4" value="야식"/>
                            <label for="야식">야식</label>
                            <input type="checkbox" id="간식" class="option-Box4" value="간식" />
                            <label for="간식">간식</label>
                            <input type="checkbox" id="술안주" class="option-Box4" value="술안주" />
                            <label for="술안주">술안주</label>
                            <input type="checkbox" id="해장" class="option-Box4" value="해장" />
                            <label for="해장">해장</label>
                            <input type="checkbox" id="식사" class="option-Box4" value="식사" />
                            <label for="식사">식사</label>
                            <input type="checkbox" id="기타" class="option-Box4" value="기타" />
                            <label for="기타">기타</label>
                        </div>
                    </div>
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