import React, { useEffect, useState } from 'react';
import '../css/home.css';
import ListItems from '../components/ListItems';
import AddItem from '../components/AddItem';
import axios from 'axios';
import ListFolders from '../components/ListFolders';
import AddFolder from '../components/AddFolder';

function Home(){
    

    

    return(
        <>
            <div className="container mt-4">
                <div className="d-flex justify-content-start mt-2">
                    <a type="button" href="/login">
                        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" className="bi bi-skip-backward text-danger" viewBox="0 0 16 16">
                                    <path d="M.5 3.5A.5.5 0 0 1 1 4v3.248l6.267-3.636c.52-.302 1.233.043 1.233.696v2.94l6.267-3.636c.52-.302 1.233.043 1.233.696v7.384c0 .653-.713.998-1.233.696L8.5 8.752v2.94c0 .653-.713.998-1.233.696L1 8.752V12a.5.5 0 0 1-1 0V4a.5.5 0 0 1 .5-.5zm7 1.133L1.696 8 7.5 11.367V4.633zm7.5 0L9.196 8 15 11.367V4.633z"/>
                        </svg>
                    </a>
                </div>
                <div className="row text-center">
                    
                    <h2>Folders</h2>
                    <AddFolder/>
                    <ListFolders/>
                </div>
            </div>
        </>
    )
} 

export default Home;