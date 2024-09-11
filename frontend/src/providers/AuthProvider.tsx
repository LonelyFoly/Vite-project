import React, { createContext, useState, ReactNode } from 'react';

type AuthContextProps = {
    children: ReactNode;
};


type User = {
    /*
    хз надо или нет
    id: number;
    username: string;
    email: string;
    */

};

type AuthContextValue = {
    user: User | null;
    setUser: React.Dispatch<React.SetStateAction<User | null>>;
};

export const AuthContext = createContext<AuthContextValue | null>(null);

export const AuthProvider = ({ children }: AuthContextProps) => {
    const [user, setUser] = useState<User | null>(null);

    const authContextValue: AuthContextValue = {
        user,
        setUser,
    };

    return (
        <AuthContext.Provider value={authContextValue}>
            {children}
        </AuthContext.Provider>
    );
};
