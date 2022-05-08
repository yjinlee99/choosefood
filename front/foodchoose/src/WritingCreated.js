import React from "react";  

const DetailList = (props) => {

    return (
        <div>
            {props.countList && props.countList.map((i, num) => (
                <div key={i} >
                    <div className="Condition" id="Steps">
                        <div className="Step" id="stepWord"> STEP {num+1} </div>
                        <textarea id="Step-textarea" className="Step" /> 
                        <input type="file" id="Step-photo" className="Step" />
                    </div>
                </div>
            ))}
        </div>
    )
}


export default DetailList