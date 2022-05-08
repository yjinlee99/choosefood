import React, {useState} from "react";
import './Tab.css';
import OptionTable from './OptionTable';

const Tab = () => {
    const [ open, setOpen ] = useState(false);
    const handleClick = () => {
        setOpen(!open);
    }

return (
    <div>
        <div id="sidebar" className={open ? 'tabOpen':'tabClose'}>
            <OptionTable />
            <div onClick={handleClick} id="tabBtn">&gt;</div>
        </div>
    </div>
    )
}
export default Tab;