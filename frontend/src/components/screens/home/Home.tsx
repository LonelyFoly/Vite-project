
import {useContext} from "react";
import {AuthContext} from "../../../providers/AuthProvider.tsx";
import styles from "./Home.module.css";
import {Link} from "react-router-dom";

function Home() {
    //const { user, setUser } = useContext(AuthContext);
    const authContext = useContext(AuthContext);

    if (!authContext) {
        return null; // Рендерим null, если контекст не определен
    }

    const { user, setUser } = authContext;
    return (
        <div>
            <header>
                <div className={styles.logo}>Quixor</div>

                <div>
                    {user ? (
                            <Link
                                to={"/"}
                                className={styles.button}
                                onClick={() => setUser(null)}
                            >Log out</Link>
                        ) :
                        <Link
                            to={"/auth"}
                            className={styles.button}
                        >Log in</Link>
                    }

                </div>
            </header>
            <div className={styles.container}>
                <h1 className={styles.h1}>Some greeting text</h1>
                <Link to={"/tasks"} className={styles.button} style={{fontSize:'40px'}}>Work</Link>
            </div>
        </div>

    )
}

export default Home