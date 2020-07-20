import setuptools

with open("README.md", "r") as f:
    project_read_me = f.read()

with open('LICENSE') as f:
    project_license = f.read()

setuptools.setup(
    name="parking_area",
    version="0.0.1",
    author="Kim Kuhyun",
    author_email="dreamx119@gmail.com",
    description="Kururu module project using python",
    long_description=project_read_me,
    license=project_license,
    long_description_content_type="text/markdown",
    url="https://github.com/Rick00Kim/SkillUp_Coding/tree/master/ModuleProjects/ParkingArea/UsingPython",
    packages=setuptools.find_packages(),
    classifiers=[
        "Programming Language :: Python :: 2.7.18",
        "License :: OSI Approved :: MIT License",
        "Operating System :: OS Independent",
    ],
    python_requires='>=3.5',
)
