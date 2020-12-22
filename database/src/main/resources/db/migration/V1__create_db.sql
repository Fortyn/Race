
CREATE TABLE public.auto (
    id integer NOT NULL,
    mark text NOT NULL,
    engine text NOT NULL,
    power integer NOT NULL,
    engine_volume integer NOT NULL,
    tire_mark text NOT NULL,
    driver_id integer NOT NULL
);


ALTER TABLE public.auto OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 426106)
-- Name: Auto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.auto ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.auto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 205 (class 1259 OID 426135)
-- Name: Driver; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.driver (
    id integer NOT NULL,
    start_num integer NOT NULL,
    initials text NOT NULL,
    city text NOT NULL,
    instagram text NOT NULL,
    license text NOT NULL,
    team_id integer NOT NULL
);


ALTER TABLE public.driver OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 426133)
-- Name: Driver_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.driver ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.driver_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 199 (class 1259 OID 426110)
-- Name: Stage_qualification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.stage_qualification (
    id integer NOT NULL,
    stage_number integer NOT NULL,
    place integer NOT NULL,
    best integer NOT NULL,
    worst integer NOT NULL,
    points integer NOT NULL,
    user_id integer NOT NULL
);


ALTER TABLE public.stage_qualification OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 426108)
-- Name: Stage_qualification_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.stage_qualification ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.stage_qualification_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 201 (class 1259 OID 426117)
-- Name: Stage_result; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.stage_result (
    id integer NOT NULL,
    tanso integer NOT NULL,
    cuiso integer NOT NULL,
    place integer NOT NULL,
    qual_id integer NOT NULL
);


ALTER TABLE public.stage_result OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 426115)
-- Name: Stage_result_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.stage_result ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.stage_result_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 203 (class 1259 OID 426127)
-- Name: Team; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.team (
    id integer NOT NULL,
    name text NOT NULL
);


ALTER TABLE public.team OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 426125)
-- Name: Team_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.team ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.team_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2714 (class 2606 OID 426105)
-- Name: Auto Auto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auto
    ADD CONSTRAINT auto_pkey PRIMARY KEY (id);


--
-- TOC entry 2722 (class 2606 OID 426142)
-- Name: Driver Driver_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.driver
    ADD CONSTRAINT driver_pkey PRIMARY KEY (id);


--
-- TOC entry 2716 (class 2606 OID 426114)
-- Name: Stage_qualification Stage_qualification_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stage_qualification
    ADD CONSTRAINT stage_qualification_pkey PRIMARY KEY (id);


--
-- TOC entry 2718 (class 2606 OID 426124)
-- Name: Stage_result Stage_result_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stage_result
    ADD CONSTRAINT stage_result_pkey PRIMARY KEY (id);


--
-- TOC entry 2720 (class 2606 OID 426154)
-- Name: Team Team_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team
    ADD CONSTRAINT team_pkey PRIMARY KEY (id);


--
-- TOC entry 2723 (class 2606 OID 426148)
-- Name: Auto Auto_driver_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auto
    ADD CONSTRAINT auto_driver_id_fkey FOREIGN KEY (driver_id) REFERENCES public.driver(id);


--
-- TOC entry 2727 (class 2606 OID 426155)
-- Name: Driver Driver_team_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.driver
    ADD CONSTRAINT driver_team_id_fkey FOREIGN KEY (team_id) REFERENCES public.team(id);


--
-- TOC entry 2724 (class 2606 OID 426170)
-- Name: Stage_qualification Stage_qualification_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stage_qualification
    ADD CONSTRAINT stage_qualification_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.driver(id);


--
-- TOC entry 2725 (class 2606 OID 426160)
-- Name: Stage_result Stage_result_qual_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stage_result
    ADD CONSTRAINT Stage_result_qual_id_fkey FOREIGN KEY (qual_id) REFERENCES public.stage_qualification(id);


-- Completed on 2020-12-16 21:57:48

--
-- PostgreSQL database dump complete
--

