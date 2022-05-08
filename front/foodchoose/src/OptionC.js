import React, { useState } from "react";

const InputBox = ({ row, onHandleClickedOption }) => {
    const [bClicked, setClicked] = useState(false);

    const clickHandler = ({ target }) => {
        setClicked(!bClicked);
        onHandleClickedOption(row.id, target.clicked);
    };

    return (
        <>
            <input type="checkbox" isClicked={bClicked} onChange={(e) => clickHandler(e)} />
        </>
    );
};

export default InputBox;