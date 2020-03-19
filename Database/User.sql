--
-- PostgreSQL database dump
--

-- Dumped from database version 11.4 (Ubuntu 11.4-1.pgdg18.04+1)
-- Dumped by pg_dump version 11.4 (Ubuntu 11.4-1.pgdg18.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: kiwong; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA kiwong;


ALTER SCHEMA kiwong OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: orang; Type: TABLE; Schema: kiwong; Owner: postgres
--

CREATE TABLE kiwong.orang (
    password character varying NOT NULL,
    tgl_masuk date NOT NULL,
    tanggal_keluar date NOT NULL,
    alamat character varying NOT NULL,
    telepon integer NOT NULL,
    username character varying NOT NULL,
    namalengkap character varying NOT NULL,
    id integer NOT NULL,
    role character varying
);


ALTER TABLE kiwong.orang OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: orangmodel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orangmodel (
    id integer NOT NULL,
    alamat character varying(255),
    namalengkap character varying(255),
    password character varying(255),
    tanggal_keluar timestamp without time zone,
    telepon integer,
    tgl_masuk timestamp without time zone,
    username character varying(255)
);


ALTER TABLE public.orangmodel OWNER TO postgres;

--
-- Data for Name: orang; Type: TABLE DATA; Schema: kiwong; Owner: postgres
--

COPY kiwong.orang (password, tgl_masuk, tanggal_keluar, alamat, telepon, username, namalengkap, id, role) FROM stdin;
aaasda	2019-04-17	2019-04-16	b	2	b	b	2	bukanadmin
ahay	2019-05-17	2019-05-16	jalan masjid darussalam	8	bcd	a	1	admin
\.


--
-- Data for Name: orangmodel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orangmodel (id, alamat, namalengkap, password, tanggal_keluar, telepon, tgl_masuk, username) FROM stdin;
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, true);


--
-- Name: orangmodel orangmodel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orangmodel
    ADD CONSTRAINT orangmodel_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

