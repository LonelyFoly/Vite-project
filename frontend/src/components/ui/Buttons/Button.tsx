import { FC, MouseEvent } from 'react';
import styles from "./Button.module.css";

interface ButtonProps {
    text: string;
    onClick?: (event: MouseEvent<HTMLButtonElement>) => void;
}

const Button: FC<ButtonProps> = ({ text, onClick }) => {
    return (
        <button className={styles.button} onClick={onClick}>
            {text}
        </button>

    );
};

export default Button;
