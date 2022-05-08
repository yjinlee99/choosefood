import React, { useState, } from 'react';
import './Option.css';

const OptionTable = () => {
    const themeFormData = [
        { id: 1, name: "한식" },
        { id: 2, name: "중식" },
        { id: 3, name: "일식" },
        { id: 4, name: "양식" },
        { id: 5, name: "분식" },
        { id: 6, name: "디저트" },
    ];

    const tasteFormData = [
        { id: 7, name: "매콤" },
        { id: 8, name: "달콤" },
        { id: 9, name: "고소" },
        { id: 10, name: "짭짤" },
    ];

    const ingreFormData = [
        { id: 11, name: "고기" },
        { id: 12, name: "채소" },
        { id: 13, name: "떡" },
        { id: 14, name: "밥" },
        { id: 15, name: "해물" },
        { id: 16, name: "과일" },
        { id: 17, name: "빵/과자" },
        { id: 18, name: "두부/계란/우유" },
        { id: 19, name: "면" },    
    ];    

    const situaFormData = [
        { id: 20, name: "야식" },
        { id: 21, name: "간식" },
        { id: 21, name: "술안주" },
        { id: 22, name: "해장" },
        { id: 23, name: "식사" },
        { id: 24, name: "기타"},
        
    ];

    const [ isClicked, setIsClicked ] = useState(false);
    const [ clickedOption, setClickedOption ] = useState(new Set());

    const clickHandler = ({ target }) => {
        setIsClicked(!isClicked);
        clickedOptionHandler(target.parentNode, target.value, target.checked);
    };

    const clickedOptionHandler = (box, id, isClicked) => {
        if(isClicked) {
            clickedOption.add(id);
            setClickedOption(clickedOption);
            box.style.backgroundColor = "#ff6f61";
        } else if (!isClicked && clickedOption.has(id)) {
            clickedOption.delete(id);
            setClickedOption(clickedOption);
            box.style.backgroundColor = "#fff";
        }
        return clickedOption;
    };

    return (
        <div className="Option">         
            <div className="optionStyle">
                <div id="optionL1">
                <div className="options1">
                    {themeFormData.map((Option) => (
                        <label key={Option.id} id="OptionLabel">
                            <input type="checkbox" value={Option.name} id="theme" className="optionBox" onChange={(e) => clickHandler(e)} />{Option.name}
                        </label>
                    ))}
                </div>
                
                <div className="options2" >
                    {tasteFormData.map((Option) => (
                        <label key={Option.id} id="OptionLabel">
                            <input type="checkbox" value={Option.name} id="taste" className="optionBox" onChange={(e) => clickHandler(e)} />{Option.name}
                        </label>
                    ))}
                </div>
                </div>

                <div id="optionL2">
                <div className="options3" id="optionIngre">
                    {ingreFormData.map((Option) => (
                        <label key={Option.id} id="OptionLabel">
                            <input type="checkbox" value={Option.name} id="ingre" className="optionBox" onChange={(e) => clickHandler(e)} />{Option.name}
                        </label>
                    ))}
                </div>

                <div className="options4" id="optionSitua">
                    {situaFormData.map((Option) => (
                        <label key={Option.id} id="OptionLabel">
                            <input type="checkbox" value={Option.name} id="situa" className="optionBox" onChange={(e) => clickHandler(e)} />{Option.name}
                        </label>
                    ))}
                </div>
                </div>
            </div>
        </div>
    );
};

export default OptionTable;