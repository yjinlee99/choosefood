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
            
            <select id="Board-Array" onChange={handleSelect}>
                <option value="view"> 조회순 </option>
                <option value="name"> 이름순 </option>
            </select>
            <Link to="/Writing"><div className="GotoWrite"> 글쓰기 </div></Link>
            
            <div id='info-con'>
            <div id="Container">
            { posts && posts.map((a) => (
                    <div className="Content">  
                            <Link to={"/SinglePost/?" + a.title}><img src={"\\img\\"+ a.thumbImg} width="350px" height="200px" style={{borderRadius:'5px', objectFit: 'cover'}}/> </Link>

                            <div id='infoBoard'>
                                <Link to=""><div ><img id='profileBoard' src={"\\img\\profile\\"+ a.profileImg} width="50px" style={{borderRadius:'70%'}}></img> { a.profile }</div></Link>
                                <div id='infoBoard2'>
                                    <Link id='titleBoard' to={"/SinglePost/?" + a.title}><div id='titleBoard'>{ a.title }</div></Link>
                                    <div id="datehit">
                                        <div id="dateBoard">{ Date[posts.indexOf(a)] }</div> &nbsp;
                                        <div id="hitBoard">조회수 { a.view }</div>
                                    </div>
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