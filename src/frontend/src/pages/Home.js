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