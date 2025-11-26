'use client';

import { useEffect, useState } from 'react';

/**
 * ThemeToggle Component
 * 
 * A button that toggles between light and dark modes.
 * Persists preference to localStorage and respects system preference.
 */
export default function ThemeToggle() {
    const [theme, setTheme] = useState<'dark' | 'light'>('dark');

    // Initialize theme on mount
    useEffect(() => {
        // Check localStorage first
        const savedTheme = localStorage.getItem('theme') as 'dark' | 'light' | null;

        if (savedTheme) {
            setTheme(savedTheme);
            document.documentElement.setAttribute('data-theme', savedTheme);
        } else {
            // Check system preference
            const systemPrefersLight = window.matchMedia('(prefers-color-scheme: light)').matches;
            const initialTheme = systemPrefersLight ? 'light' : 'dark';
            setTheme(initialTheme);
            document.documentElement.setAttribute('data-theme', initialTheme);
        }
    }, []);

    const toggleTheme = () => {
        const newTheme = theme === 'dark' ? 'light' : 'dark';
        setTheme(newTheme);
        localStorage.setItem('theme', newTheme);
        document.documentElement.setAttribute('data-theme', newTheme);
    };

    return (
        <button
            onClick={toggleTheme}
            className="theme-toggle"
            aria-label={`Switch to ${theme === 'dark' ? 'light' : 'dark'} mode`}
            title={`Switch to ${theme === 'dark' ? 'light' : 'dark'} mode`}
        >
            {theme === 'dark' ? '☀️' : '🌙'}
        </button>
    );
}
