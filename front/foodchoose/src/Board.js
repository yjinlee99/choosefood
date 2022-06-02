import React, { useState, useEffect } from 'react';
import './Board.css';
import SearchIcon from '@material-ui/icons/Search';
import Banner from './Banner';
import { Link } from "react-router-dom";


function Board() {
    const [posts, setPosts] = useState([[]]);
    const [Date, setDate] = useState([]);
    useEffect(() => {
        fetch('/posts')
            .then(response => response.json())
            .then(posts => {
                setPosts(posts);
                var arr = [];
                var str1, str2;
                for(var i=0; i<posts.length;i++) {
                    str1 = posts[i].uploadDate.split("T");
                    str2 = str1[1].split(".");
                    str1 = str1[0] + " / " + str2[0];
                    arr[i] = str1;
                }
                setDate(arr);
            });
    },[])

    const [board, setBoard] = useState("")
    const onBoardHandler = (event) => {
        setBoard(event.currentTarget.value)
    }
    const goBackend = () => {
        if(board == "") {
            alert("검색어를 입력하세요.")
            return;
        } else {
            fetch('/posts', {
                method: 'post',
                body: JSON.stringify({
                    board: board
                })
            })
            window.location.replace("/Board")
        }
    }

        const [ selected, setSelected ] = useState("");
        
        let nameArray;
        let viewArray;

        const handleSelect = (e) => {
            setSelected(e.target.value);

        if (selected != "name") {
            nameArray = posts.sort(function (a,b) {
                let x = a.title.toLowerCase();
                let y = b.title.toLowerCase();
                if(x < y) {
                    return -1;
                }
                if(x > y) {
                    return 1;
                }
             });
        } else {
            viewArray = posts.sort(function (a,b) {
                return b.view - a.view;
            });
        }
    }

    return (
        <div className="Board">

            <div className="Header">
                <Banner/>
            </div>

            <div className="Search">
                <input className="Search-input" placeholder=" 통합 검색" type="text" onChange={onBoardHandler}/>
                <Link to="/Board"><SearchIcon className="Search-icon" onClick={goBackend}/></Link>
            </div>
        
            <select id="Array" onChange={handleSelect}>
                <option value="name"> 이름순 </option>
                <option value="view"> 조회순 </option>
            </select>

            <Link to="/Writing"><div className="GotoWrite"> 글쓰기 </div></Link>
            
            <div id='info-con'>
            <div id="Container">
                { posts && posts.map((a) => (
                    <div className="Content">  
                        <div className="Thump">
                            <Link to={"/SinglePost/?" + a.title}>
                                <div className="Thump-link"> <img src={"\\img\\"+ a.thumbImg} width="350" height="160" /> </div>
                            </Link>
                        </div>
                        
                        <div className="Detail">
                            <div className="Profile">
                                <Link to="">
                                    <div className="Profile-link"><img src="/img/profile.png" width="50px"></img> { a.profile }</div>
                                </Link>
                            </div>

                            <h4 className="Title">
                                <Link to={"/SinglePost/?" + a.title}><div className="Title-link">{ a.title }</div></Link>
                            </h4>
                            
                            <div>
                                <div className="Date">{ Date[posts.indexOf(a)] }</div> &nbsp;
                                <div className="Hits">조회수 { a.view }</div>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
            </div>
        </div>
    );   
}

export default Board;