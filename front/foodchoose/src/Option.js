import React from 'react';
import Banner from './Banner';
import OptionTable from './OptionTable';
import './Option.css';

function Option() {

    return (
        <div className="Option">         
            <div className="Header"><Banner/></div>
            <OptionTable />
            {/* <Link to="/Recipe"><input type="submit" id="Find" value="찾기" /></Link> */}
        </div>
    );
};

export default Option;