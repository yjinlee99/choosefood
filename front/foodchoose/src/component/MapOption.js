import React from 'react';
import { Link } from 'react-router-dom';
import Banner from '../Banner';
import MapOptionTable from './MapOptionTable';
import './MapOption.css';

function MapOption() {

    return (
        <div className="Option">         
            <div className="Header"><Banner/></div>
            <MapOptionTable />
            {/* <Link to="/Recipe"><input type="submit" id="Find" value="찾기" /></Link> */}
        </div>
    );
};

export default MapOption;