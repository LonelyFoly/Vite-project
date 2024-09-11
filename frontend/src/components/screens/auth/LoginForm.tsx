import React, {useState} from 'react';
import { Card, Form, Input, Button } from 'antd';
import styles from "./LoginForm.module.css";
import {Link, useLocation} from "react-router-dom";


/*import IUserRegData from "../../../axios/user.type.ts";*/

import IUserLogData from "../../../axios/user.type.ts";
import axios from "axios";
import UserDataService from "../../../axios/user.service.ts";
const LoginForm = () => {
    const location = useLocation()
    const isReg = location.pathname == "/registration"
    const [formData, setFormData] = useState({
        surname: '',
        name: '',
        email: '',
        token: '',
        password: ''
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        // здесь проверка
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleSubmit = (e: React.FormEvent) => {
        console.log("try to login:");

        if (!isReg){


            const data: IUserLogData = {
                login: formData.name,
                password: formData.password
            };
        let resp = UserDataService.auth(data);
            console.log(resp);
            /*.then((response: any// eslint-disable-line @typescript-eslint/no-explicit-any
            ) => {
                console.log(response.data);
                setFormData({
                    surname: '',
                    email: '',
                    token: '',
                    name: response.data.name,
                    password: response.data.password,

                });
                });*/
        }
        else
        {
            let response =
                axios.post("http://localhost:8090/registration",
                    {login: "root", password: "root", confirmPassword: "root",
                    email:"kek@kek.ru"});
            console.log(response);
            /*const data: IUserData = {
                surname: '',
                email: '',
                token: '',
                name: formData.name,
                password: formData.password,

            };
            UserDataService.reg(data)
                .then((response: any// eslint-disable-line @typescript-eslint/no-explicit-any
                ) => {
                    console.log(response.data);
                    setFormData({
                        surname: '',
                        email: '',
                        token: '',
                        name: response.data.name,
                        password: response.data.password,

                    });
                });*/
        }
        e.preventDefault();
    };
    return (
        <div className={styles.container}>
            <Card className={styles.signIn}>
                <h1>Quixor</h1>
                <Form onFinish={handleSubmit}>
                    {isReg ? (
                        <>
                            <Form.Item name="name">
                                <Input
                                    className={styles.input}
                                    type="text"
                                    placeholder="name"
                                    value={formData.name}
                                    onChange={handleChange}
                                />
                            </Form.Item>
                            <Form.Item name="surname">
                                <Input
                                    className={styles.input}
                                    type="text"
                                    placeholder="surname"
                                    value={formData.surname}
                                    onChange={handleChange}
                                />
                            </Form.Item>
                            <Form.Item name="token">
                                <Input
                                    className={styles.input}
                                    type="text"
                                    placeholder="token"
                                    value={formData.token}
                                    onChange={handleChange}
                                />
                            </Form.Item>
                        </>
                    ): (<></>)}

                    <Form.Item name="email">
                        <Input
                            className={styles.input}
                            type="text"
                            placeholder="e-mail"
                            value={formData.email}
                            onChange={handleChange}
                        />
                    </Form.Item>

                    <Form.Item name="password">
                        <Input
                            className={styles.input}
                            type="password"
                            placeholder="password"
                            value={formData.password}
                            onChange={handleChange}
                        />
                    </Form.Item>

                    <Form.Item>
                        <Button className={styles.button} type="primary" htmlType="submit">
                            {isReg ? 'Sign up' : 'Log in'}
                        </Button>
                    </Form.Item>
                    {isReg ? (
                        <></>
                    ) : <Link to={"/registration"} className={styles.text}>Sign up</Link>
                    }
                </Form>
            </Card>
        </div>

    );
};

export default LoginForm;