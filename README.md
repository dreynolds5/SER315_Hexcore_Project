# SER315 Group Project - Racer Registration System
   **Design Pattern Used: Strategy & Observer

   ## Project Overview
       This project is a console base Racer Registration System, that allows users to:
      - Log in as a racer
      - View available races
      - Register for offical and unoffical races
      - Recieves real time notification of a registration's success or failure

The System Implements:
   1) The Strategy Pattern:
      Controls different race registration rules
   2) The Observer Pattern:
      Displays registration result messages independently of the logic

## How to Run the Program


**Main entry point:** `RacerView` class  

    Test users:
    
         **User 1*
          Name:
            - Alex_Morgan
          Password:
            - FastR4cer!
            
         **User 2*
          Name:
            - Shawn_Morgan
         Password:
            - Fast3rR4cer!
            
   ## How the Observer Output Work
  ### Log-in

        1: log in
        2: exit
        Enter your choice:
        1
        Enter name to login:
        Alex_Morgan
        Enter password to finish logging in:
        FastR4cer!
   
   ### Successful Registration 
        what it means:
          -the racer entered a valied username and password.
        what the system does:
          -Grants access to the main manu
          -Allows the user to view races, register, logout, or exit.
        Observer Behavior:
          -displays notification message
            -successful registration
            -failis registration
    
   ### Failed Registration
      1) Duplicate Registration
        What it means:
          -The racer tried to register for a race they already in.
        what the system does:
          - Blocks the registration
          - Prevents duplicate entries
        Observer Behavior:
          -displays notification message
            - Successful registratio
            - Failis registration
            - Keeps registration logic separate from the output messages 

       2) Deadline Passed
        What it means:
          - The racer attempted to register after the offical cutoff time.
        what the system does:
          - Provents late registration
          - Enforces time frame to enter race using the Strategy Pattern
        Observer Behavior:
          - Fail notification message

       3) Race Full
        What it means:
          - The racer has reached its participation limit.
        what the system does:
          - Provents additional racers frin registering
          - Enforces capacity
        Observer Behavior:
          - Fail notification message

  ### Logout Outcomes
      What it mean:
        - The racer chooses to log out of the system.
      What the system does:
        - Ends the user session
        -Returns to the login menu

  ### Exit Outcome
    What it means"
      - The user chooses to fully exit the program.
    What they system does:
      -Safely terminates the application
      -Ends all active sessions
     
## Design Pattern Summary
   ### Strategy Pattern
      Controls how racers register depending on race type:
         -RaceRegister (interface)
         -OfficalRaceRegister
         -UnofficalRaceRegister

   ### Observer Pattern
      Send notification of Registration Output message
         -Observer (interface)
         -SuccessObserver
         -FailedObserver
         -RacerController (Subject)

## Key Class files
   1) RecerView
      - User interface
   2) RacerController
      - System logic and Observer
   3) Race
      - Race data
   4) Racer 
      - Racer data
   5) RaceRegister
      - Strategy interface
   6) OfficalRaceRegister
      - Offical race logic
   7) UnofficalRaceRegister
      - Unoffical race logic
   8) Observer
      - Observer interface
   9) SuccessObserver
      - Success message
   10) FailedObserver
       - Failed message
      
   _____________________________________________________________________________________________________________________
  


# ASU SER315 Group Project Template

Welcome to SER315's Group Project Template! This comprehensive template and
guide was created to help you navigate your first big group project of this
degree path at ASU! Below, you'll find an overview of what this repository is,
why it was created, and how to use it. Additionally, you will find a brief
tutorial for getting started with Git and GitHub, which is a easy way to
enable seamless collaboration with your teammates.

Any issues or concerns with this repository can be communicated to your
instruction team, which we will take on to make this template as useful and
helpful as possible!

### Contents

1. [What Is This Repository](#1-what-is-this-repository)
2. [Why This Exists](#2-why-this-exists)
3. [File Structure](#3-file-structure)
4. [How to Use This](#4-how-to-use-this)
5. [Basic Git](#5-basic-git)
   1. [Project Setup](#51-project-setup)
      1. [Set Up Git User and SSH Key](#511-set-up-git-user-and-ssh-keysh-key)
      2. [`git fork`](#512-git-fork)
      3. [`git clone`](#513-git-clone)
   2. [Collaboration](#52-collaboration)
      1. [`git pull`](#521-git-pull)
      2. [`git commit`](#522-git-commit)
      3. [`git push`](#523-git-push)
   3. [Further Git Resources](#53-further-git-resources)

---

## 1. What Is This Repository

This repository is a template for your group project in SER315, containing
overviews of all the artifacts you'll be creating over the rest of the course,
as well as some tutorials on how to use tools and technologies you may be
unfamiliar with. It is set up with group collaboration in mind, with all
covered and recommended tools being specifically chosen to maximize the
ability for your team to work as one to complete this design.

All of the tutorials and guides contained here are very surface level and only
provide you with the minimum set of tools needed to complete this project, but
they are all extremely powerful in their own right, widely used in the
industry, and are worth learning further.

One special mention is [Git](https://git-scm.com/), the tool that GitHub is
built around. Git is a version control software that is nigh-on ubiquitous in
use, and using this template will give you an opportunity to get some very
basic familiarity with it before it comes into broader use in SER316 and
beyond.

The additional tools that will be covered here are
[Markdown](https://www.markdownguide.org/) and
[Mermaid](https://mermaid.js.org/), with more specific instructions on each
for [VSCode](https://code.visualstudio.com/) and
[IntelliJ IDEA](https://www.jetbrains.com/idea/).

---

[Return to Top](#asu-ser315-group-project-template)

---

## 2. Why This exists

This template was built because we identified a need in a collaborative
workflow for this courses project. In previous iterations, Astah UML was the
program of choice for this project, and deliverables were created and shared
over Google Docs. While Google Docs was great for collaboration, Astah was
most certainly not. Teams would end up splitting up the diagramming work, and
as a result, members would be missing whole diagrams at a time, and if any
needed to be updated, then that one member with the diagram would have to do
it. That single point of failure is not great, and it can cause some tensions
that we really want to avoid.

Since the refresh of this course by Dr. Mehlhase and Dr. Jain, additional
elements were added to the project that included coding features of the
design. This felt like a great opportunity to give students a resource for
managing that, along with a set of guides that would enable collaboration and
unify how we think about working together on software into our future courses.

Ultimately, this template and repository exists to familiarize you with tools
and workflows that you will be incorporating more officially in future
courses, while also giving you a solid and tested workflow for collaboration.

---

[Return to Top](#asu-ser315-group-project-template)

---

## 3. File Structure

This project is organized out of the box into four directories:
`/deliverables`, `/diagrams`, `/img_resources`, and `/src`. Additionally, this
README is in the root of the directory and serves as your entry point into
the project. There is also a `.gitignore` file that filters unnecessary files
from being uploaded to this repository.

#### [`/deliverables`](/deliverables/)

Inside this directory there are templates for all four of the deliverables
you will be responsible for over this course. They include sections for each
of the elements you are tasked to provide for that deliverable, with space for
your reflections.

These are all Markdown files which can be edited in any code editor, including
Notepad, VSCode, IntelliJ IDEA, etc. Included in this folder is a file
called
[`_deliverables_instructions.md`](/deliverables/_deliverables_instructions.md)
that contains more information on each section of the deliverable documents,
as well as a brief overview of Markdown, basic syntax, and features useful
to this project (embedding images, exporting PDFs).

#### [`/diagrams`](/diagrams/)

This directory contains a file
[`_diagrams_instructions.md`](/diagrams/_diagrams_instructions.md) and a
sub directory [`/examples/`](/diagrams/examples/).

The instructions file contains instructions and guides for creating the
various UML diagrams you will need for this project using Mermaid. Mermaid
is a code-based diagraming tool that can render a wide variety of charts
and diagrams from a few lines of code. What makes that nice is that it plays
well with our version control systems like Git, and it is easily edited and
maintained by the whole team at all stages of the project. The instructions
also contain guides on how to export the diagrams to images
for later embedding into the deliverables.

The `examples` folder contains example diagrams for the three types of
diagrams required for this project for you to learn from.

#### [`/img_resources`](/img_resources/)

This directory contains images that are used in these guide documents, but
can also be used to store your deliverable's images as well.

#### [`/src`](/src/)

This directory comes with two files to start:
[`README.md`](/src/README.md) and
[`src_instructions.md`](/src/src_instructions.md). `README.md` is a file you
will fill out for later deliverables to explain to the instruction staff how
to set up and run your software.

`src_instructions.md` contains guides for setting up a Java project from
scratch without IDE assistance or starter code snippets, and also contains
guides on easier ways to manage building and running your code as you develop
it, with a focus on VSCode and IDEA workflows, but those are absolutely
optional.

---

[Return to Top](#asu-ser315-group-project-template)

---

## 4. How to Use This

You will be creating a copy of this template into your own GitHub account
by [forking](#511-git-fork) it. Then, you and your team mates will collaborate
on the many artifacts required for the project, by using a variety of
[basic git](#5-basic-git) features.

There are two basic ways to interact with the repository: local editing
(recommended), and through the GitHub interface in your browser (not
recommended).

---

### 4.1 Local Editing

To work on this project by having a copy on your local machine, you will first
need to install [Git](https://git-scm.com/downloads). This will come with
the CLI tools for Git (and importantly for Windows, Git Bash).

Optionally, you can install a Git GUI client such as
[GitHub Desktop](https://github.com/apps/desktop) that will give you an easy
interface for using Git and GitHub.

I personally recommend getting comfortable with the command line interface
for Git when starting out to get a feel for what these UIs are abstracting
away, but even I use UI implementations (VSCode and IDEA both have Git UI
implementations that are really great).

Once that is done, you'll [`git clone`](#512-git-clone) the project from
GitHub onto your local machine for editing.

The benefit here is that you can edit and create diagrams, code, and
deliverables from your IDE or editor of choice, and in future classes you will
100% be required to have a local install and setup for Git, so might as well
'git' it going now!

---

[Return to Top](#asu-ser315-group-project-template)

---

### 4.2 Browser Editing

I don't recommend going this route, but you can also edit files and make
commits straight from the GitHub file viewer. The upside to this is you can
make small or simple changes from the browser as needed, but the downside is
you don't have the benefits of any tools and are limited to editing raw text
files.

While it is theoretically possible to complete most parts of this group
project strictly through GitHub's browser editors, I would not recommend it
as it is honestly more complicated and cumbersome than taking the time to get
things properly set up locally.

---

[Return to Top](#asu-ser315-group-project-template)

---

## 5. Basic Git

From here on, this guide will be assuming two things: that you're going to
work off of a local repository, and that you will be using a version of
the Bash shell (very common shell syntax). On Windows, Git Bash shell is installed when you install Git automatically.

This section will give you a bare-bones set of commands in Git to get you
going. The software has incredible depth, but for most people, you'll only
really interact with a handful of commands for any project unless you want
to become a power-user.

---

### 5.1 Project Setup

This section will relate to setting up your project for the first time.

We will assume you already have a GitHub account created. If not, do so now.

This section will be important to read and execute in order!

---

#### 5.1.1 Set up Git User and SSH Key

We'll start by creating an SSH key that we can use to access and work with
private Git repos on GitHub. This process requires some command line work,
but ultimately isn't too complicated and can be completed in a few steps.

We'll start by configuring your local install of Git to use your GitHub
email address.

Open your Bash shell and type in:

`git config --global user.name "[Your GitHub Username or Your Name]"`

Then type in:

`git config --global user.email "your.email@example.com"`

This will set your global Git settings to sign off with your username and
email that was supplied. This will be important for connecting to your
GitHub account when working on private repositories.

We'll be connecting to and working with GitHub from our local machine using
SSH, which is "Secure Shell Protocol". It allows us to connect to outside
systems from our command line securely, and by using a cryptographic key, we,
and GitHub's servers, can verify our identities.

To get this set up, we need to first generate an SSH Key locally.

Open your Bash shell and type in:

`ssh-keygen -t ed25519 -C "your_email@example.com"`

This creates a new SSH Key, using the provided email as a label. When you're
prompted to "Enter a file in which to save the key", press `Enter` to accept
the default location. If you have other keys made, this will overwrite them,
so consider giving this a more intentional name if you have other SSH keys you
work with.

At the next prompt, type in your password. It will ask you to enter it again
afterwards. The key is now created!

By default, keys are stored in `~/.ssh/`, where the `~` is your home User
folder. If you navigate to that, you'll see a `id_ed25519` and an
`id_ed25519.pub` file. They may have different names if you chose a different
key name. The `.pub` file is your public key, and the other is your private
key. Make sure to keep that safe, if it becomes lost, so does your access
with this keyset.

The next step is to add it to your GitHub account. Navigate to your account
settings, and from the left-side menu, click on "SSH and GPG Keys". Click on
the green "New SSH Key" button.

![GitHub SSH Key](/img_resources/InstructionImages/git_sshkey.png)

Enter a Title for this SSH Key. I called mine "ASU ID". In the Key textbox,
copy and paste the contents of your `.pub` file. You will want to make sure
to open that file with a text editor. On Windows, the `.pub` extension is for
Office Publisher, and will try to open it that way if you just double-click
on it.

Click the "Add SSH Key" button, and you're all set to work with private
repositories you have access to!

---

[Return to Top](#asu-ser315-group-project-template)

---

#### 5.1.2 `git fork`

> **CRITICAL NOTE:** Only one team member per team should fork this
> repository!!!

In Git, you can "fork" any repository. This effectively makes a copy of the
project that **you** own and can make changes to, that will not effect the
original. This is the behavior we want for making our own version of this
template.

There are two ways to do this, but we'll focus on the easier and more common
use for now: GitHub forking.

On the main repository page, there will be a series of buttons along the top
like this:

![GitHub Forking Button](/img_resources/InstructionImages/git_fork_button.png)

Go ahead and click the "Fork" button. This will take you to a page that looks
like this.

![GitHub Create Fork](/img_resources/InstructionImages/git_create_fork.png)

Change the name of the repository to
`SER315_[SEMESTER/YEAR][A/B/C]_[GROUPNAME]`. For example,
`SER315_FALL25C_SCHATTENWALD`.

Then click "Create fork".

That will create a copy of this repository into your personal GitHub, however,
we will need to add collaborators to let other people edit this repository
as well.

![Github Settings](/img_resources/InstructionImages/git_github_settings.png)

From the repository page, click on the Settings button, and from the left-side
menu, click on Collaborators. GitHub will have you sign in again, and you
will then see a button to "Add people". Go ahead and get/invite the GitHub
accounts of your teammates, and also invite `ser316asu` to give instructors
access. Now all parties can make changes to the group project.

Forked projects by their nature can not have different visibility settings
from their original. This means that we can't make the project private as it
stands. In order to change that, we need to go back to General Settings,
which is on the top of the left-hand menu. Scroll all the way down to the
"Danger Zone", and click "Leave Fork Network". This will disconnect this
repository from the original, but will also mean we can change its visibility.

![GitHub Danger Zone](/img_resources/InstructionImages/git_dangerzone.png)

Detaching the repo will take a second. Refresh after a few seconds, and
"Change Visibility" will be an option. Click that, and select "Change to
Private". It will ask you a series of questions. Click through them all,
and your copy of the repository will now be made private for your team and
instruction staff.

Congratulations, you've got your own copy of this
template!

---

[Return to Top](#asu-ser315-group-project-template)

---

#### 5.1.3 `git clone`

So we have a copy of the repository, how do we get that onto our machine for
editing? We use the `git clone` command!

Open up your Bash shell in the folder you want to be working from. I suggest
keeping this folder with all of your other SER315 files, and keeping it in a
Group Project folder of some kind, but you can place it wherever you want.

![GitHub Clone](/img_resources/InstructionImages/git_clone_github.png)

When you have your Bash open, go to the main repository page, and click the
green "Code" button. Make sure to select "SSH", and then go ahead and copy
the link provided. This can easily be done by clicking the 'copy' button next
to the link, or the two squares.

Onces that's copied, go to your Bash shell, and type in the following:

`git clone [URL THAT WAS COPIED]`

You will be prompted for your SSH passcode, and then you will download the
repository folder to the folder you're currently in. The terminals output
should look similar to below:

![Bash `git clone` example output](/img_resources/InstructionImages/git_clone_bash.png)

You now have a local working copy of your repository for you to edit and
make changes to as you see fit!

---

[Return to Top](#asu-ser315-group-project-template)

---

### 5.2 Collaboration

That was a lot of work to set up! But it's all worth it for the ability to
work alongside your peers and collaborate easily and effectively! In this
next section, we'll go over the basic Git commands that will enable this, and
how to work with them.

---

#### 5.2.1 `git pull`

When you open up your project each day to begin working, the first thing
you'll want to do is Pull down any changes that your team mates have been
working on. Your local workspace is in a different state than the Remote
workspace, so doing this keeps you up to date with your team.

To do this, open Bash in your root project folder, and type in:

`git pull origin main`

You will be prompted for your SSH passcode, and then Git will pull down any
changes to the project and ensure you're up to date.

`git pull` is a combination of two Git functions: `fetch` and `merge`.
`fetch` pulls down all changes from the remote repository, but keeps them
separate from your workspace. `merge` attempts to merge those changes into
your local space to make sure you are fully up to date. If you had already
made changes to some files before pulling down, you may need to resolve some
conflicts between your local codebase and the remote one. Git will walk you
through the process for each file, and you need to decided what parts that
are conflicting need to be kept or removed. Ideally, Git can handle this
merge fully automatically without intervention, but sometimes it gets
confused and you need to help it out.

The ins and outs of merge conflicts are outside the scope of this document,
but you can find more detailed information about how to resolve those
conflicts
[here](https://git-scm.com/docs/git-merge#_how_to_resolve_conflicts).

---

[Return to Top](#asu-ser315-group-project-template)

---

#### 5.2.2 `git commit`

Commits are the workhorse of Git, and are fundamental to the process. A commit
is a snapshot of changes to your project in a specific time- keeping track
of files changed, added, or deleted over time. Commits and their history allow
us to track the development of software over time, and if something goes
terribly wrong, revert back to a version that works. This is the core idea
behind version control.

It's best practice to commit your work in small chunks as you go. If you make
a change to a file or function, commit it! It's easier to understand changes
when they are small and incremental, rather than when they're huge and
overbearing.

A commit is made up of two pieces: a manifest of changes and a message.

The manifest is created automatically by tracking changes you've made to a
file. This is not done automatically, and must be manually done. To add a file
to a commit, you use the command:

`git add [filename.extension]`

This adds that file to the commit's staging area. Additionally, you can use

`git add .`

to stage all files in the entire project at once.

Once your changes are staged, you are ready to commit them. Prepare a commit
message. There are some best practices when writing commit messages that will
be more thoroughly explained in SER316, but for now just make sure you are
being descriptive enough with these that they're readable by **everyone**.

Some good examples are:

`Adds class diagram for user management system` or
`Updates deliverable 2 with activity diagram and team reflection`. Basically,
you want to start with a verb for what the commit is doing, and describe what
the commit does, not why. Use present tense, be specific, but concise,
limiting to around 50 characters.

Once that is ready, we can go ahead and make the commit! Type into your shell:

`git commit -m "[INSERT MESSAGE HERE]"`

Git will then add that commit to the ledger for the `main` branch. From here,
you can work on the next feature, or send your changes up to the remote
repository!

---

[Return to Top](#asu-ser315-group-project-template)

---

#### 5.2.3 `git push`

When you're done working for the day, or when you feel like its appropriate,
you can send your local changes to the repository up to the remote one. This
gives your teammates access to all the work you've put in, and allows them
to continue iterating on the project artifacts.

Pushing is very straightforward. Into your shell, type:

`git push origin main`

This will ask for your SSH passcode, and then send all of your changes up to
the remote repository's `main` branch.

##### RISKS

It is likely that another teammate might have pushed changes up before
you did. When you're doing a push, it's best practice to pull down
beforehand to make sure there are no conflicts, and resolve any that do
appear. Once all conflicts are dealt with, pushing should be near automatic.

---

[Return to Top](#asu-ser315-group-project-template)

---

### 5.3 Further Git Resources

Git is extremely powerful and has incredible depth, and this document really
only scraps the surface of what is possible. If you're interested in learning
more before you take courses on it, here are some good resources and topics
to look into.

#### Branches

Git allows you to branch development, so people can work on features in tandem
without impacting the main branch. This allows you to have a functioning
`main` branch for the public, while new features and things that need testing
can live on separate branches and merge into `main` when they're ready. This
is a great workflow to ensure as few conflicts as possible, but is out of the
scope of this project. It will be required in SER316 though, so if you want a
brief overview, this
[article](https://medium.com/@jacoblogan98/understanding-git-branching-5d01f3dda541)
has a pretty solid overview of the concept.

#### VSCode Git Integration

VSCode has built-in support for Git and also has GitHub integration features.
An overview of those features and how to set that up can be found
[here](https://www.qed42.com/insights/how-to-use-git-in-vs-code).

#### IDEA Git Integration

IDEA also contains built-in Git support, with a lot of really neat features
that are all accessible by the IDEA UI. More information about that can be
found
[here](https://medium.com/@vino7tech/mastering-git-and-github-integration-in-intellij-idea-a-complete-guide-to-version-control-7cf68cd7951a).
There are also many tutorial videos out there for those who are visual
learners, as this writeup doesn't do much showing and more telling.

---

[Return to Top](#asu-ser315-group-project-template)

---
