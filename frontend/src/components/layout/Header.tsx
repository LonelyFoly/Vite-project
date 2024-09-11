//import React from 'react';

import Navbar from "./Navbar.tsx";
import styles from "./Header.module.css";

const Header = () => {
    return (
        <header className={styles.header}>
            <div className={styles.logo}>Quixor</div>
            <Navbar/>

        </header>
    );
};

export default Header;