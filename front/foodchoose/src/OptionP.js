import React, { useState } from "react";

const [ clickedOption , setClickedOption ] = useState(new Set());

const onHandleClickedOption = (id, isClicked) => {
    if (isClicked) {
        clickedOption.add(id);
        setClickedOption(clickedOption);
    } else if (!isClicked && clickedOption.has(id)) {
        clickedOption.delete(id);
        setClickedOption(clickedOption);
    }
    console.log('clickedOption', clickedOption)
};

function OptioneThemeP () {
    return (
        <ul>
            {arrayData.map((row, idx) => 
            <li key={idx}>
                <label>
                    <InputBox row={row} onHandleClickedOption={onHandleClickedOption} />
                    <span>{guide.content}</span>
                </label>
            </li>
        )}
    </ul>
    )
}

export default OptioneThemeP;
