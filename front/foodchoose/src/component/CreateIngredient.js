import React from "react";

function CreateIngredient({ username, onChange, onCreate }) {
    return (
        <div>
            <input id='addText'
                name="username"
                placeholder="재료를 추가하세요."
                onChange={onChange}
                value={username}/>
            <button id="addButton" onClick={onCreate}>추가</button>
        </div>
    );
}
export default CreateIngredient;