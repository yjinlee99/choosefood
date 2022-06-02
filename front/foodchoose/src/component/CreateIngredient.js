import React from "react";

function CreateIngredient({ refrigerator, onChange, onCreate }) {
    return (
        <div>
            <input id='addText'
                name="refrigerator"
                placeholder="재료를 추가하세요."
                onChange={onChange}
                value={refrigerator}/>
            <button id="addButton" onClick={onCreate}>추가</button>
        </div>
    );
}
export default CreateIngredient;