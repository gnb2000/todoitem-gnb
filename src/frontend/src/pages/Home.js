import React, { useEffect, useState } from 'react';
import '../css/home.css';
import ListItems from '../components/ListItems';
import AddItem from '../components/AddItem';
import axios from 'axios';
import ListFolders from '../components/ListFolders';

function Home(){
    

    

    return(
        <>
            <div className="container mt-4">
                <div className="row text-center">
                    <h2>Folders</h2>
                    <ListFolders/>
                </div>

            </div>

        </>
    )
} 

export default Home;